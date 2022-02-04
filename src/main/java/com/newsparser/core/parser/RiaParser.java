package com.newsparser.core.parser;

import com.newsparser.core.parser.impl.ParserType;
import com.newsparser.core.parser.model.ParsedPostEntry;
import com.newsparser.core.parser.model.old.ParserSchema;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RiaParser implements Parser {

    List<ParserSchema> parserSchemas;

    SimpleDateFormat formatter;

    WebDriver driver;

    ParserType type;

    @Autowired
    public RiaParser(List<ParserSchema> parserSchemas, SimpleDateFormat formatter, WebDriver driver) {
        this.parserSchemas = parserSchemas;
        this.formatter = formatter;
        this.driver = driver;
        type = ParserType.RIA;
    }

    @Override
    public List<ParsedPostEntry> getPostListFromUrl() {

        List<ParsedPostEntry> postEntriesResult = new ArrayList<>();
        getValidSchema().forEach(schema -> {
            Element rootElement = getMainElement(schema);
            try {
                Elements postElements = rootElement.getElementsByClass(schema.getEachElementClass());
                postEntriesResult.addAll(processEachPost(postElements, schema));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });

        return postEntriesResult;
    }

    public List<ParsedPostEntry> parseEachLink(List<ParsedPostEntry> postEntries) throws IOException {

        postEntries.stream().filter(post -> !post.isFullParseSuccess()).forEach(link -> {
            System.out.println("link " + link.get_id());
            driver.get(link.getHref());
            getValidSchema().forEach(schema -> {
                Elements elementJsoup = Jsoup.parse(driver.getPageSource()).getElementsByClass(schema.getEachPostParserSchema().getMainPostClass());
                Assert.isTrue(elementJsoup.size() == 1,
                        "More then 1 root element. Size = " + elementJsoup.size());
                Elements articles = elementJsoup.first().getElementsByClass(schema.getEachPostParserSchema().getArticlesClass());
                articles.forEach(art -> {
             //       System.out.println(art);
                    link.addArticleToList(art.text());
                });
                //  System.out.println("getPageSource "+elementJsoup);
            });
            //Elements elementJsoup = Jsoup.parse(driver.getPageSource()).getAllElements();
            // System.out.println("getPageSource "+elementJsoup);
        });
        //  System.out.println(docs);
        return postEntries;
    }

    public void enrichTag(ParsedPostEntry post, Element element, ParserSchema schema) {
        Elements tags = element.getElementsByClass(schema.getInfoTags());
        tags.forEach(t -> post.addTagToList(t.text()));
    }

    protected Element getMainElement(ParserSchema schema) {
        Element rootElement = null;
        try {
            Document doc = Jsoup.connect(schema.getMainUrl()).get();
            Elements rootElements = doc.getElementsByClass(schema.getRootClass());
            Assert.isTrue(rootElements.size() == 1,
                    "More then 1 root element. Size = " + rootElements.size());
            rootElement = rootElements.first();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return rootElement;
    }

    protected List<ParsedPostEntry> processEachPost(Elements elements, ParserSchema schema) {
        List<ParsedPostEntry> postEntries = new ArrayList<>();
        elements.forEach(eachPost -> {
            ParsedPostEntry postEntry = new ParsedPostEntry();
            postEntry.setCreatedAt(formatter.format(new Date()));
            enrichTag(postEntry, eachPost, schema);

            Attributes attributes;
            if (schema.getSubElement() != null) {
                attributes = eachPost.getElementsByClass(schema.getSubElement()).get(0).attributes();
            } else {
                attributes = eachPost.attributes();
            }
            attributes.forEach(attribute ->
            {
                if (attribute.getKey().equals(schema.getTitleTag())) {
                    postEntry.setTitle(attribute.getValue());
                }
                if (attribute.getKey().equals(schema.getHrefTag())) {
                    postEntry.setHref(attribute.getValue());
                }
            });
            postEntries.add(postEntry);
        });
        return postEntries;
    }

    public List<ParserSchema> getValidSchema() {
        return parserSchemas.stream().filter(schema -> schema.getParserType().equals(type)).collect(Collectors.toList());
    }
}
