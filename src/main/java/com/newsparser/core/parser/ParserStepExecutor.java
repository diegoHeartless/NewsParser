/*
package com.newsparser.core.parser;

import com.newsparser.core.parser.model.old.ParserJsonSchema;
import com.newsparser.core.parser.model.ParserStep;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.List;

@Service
public class ParserStepExecutor {
    List<ParserJsonSchema> parsers;
    WebDriver driver;

    @Autowired
    public ParserStepExecutor(List<ParserJsonSchema> parsers, WebDriver driver) {
        this.parsers = parsers;
        this.driver = driver;
    }

    @Scheduled(fixedDelay = 60000)
    public void executeAllParsers(){
        parsers.forEach(parser ->{
                System.out.println(goToPage(parser));
        });
    }

    protected Document getDocument(ParserJsonSchema schema)  {
        return goToPage(schema);
    }

    public Document goToPage(ParserStep step) {
        Document document = null;
        switch (step.getParsBy()){
            case JSOUP:
                try {
                    document = Jsoup.connect(step.getParseValue()).get();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                break;
            case PHANTOM:
                driver.get(step.getParseValue());
                document = Jsoup.parse(driver.getPageSource());
                break;
        }
        Assert.notNull(document, "Error during main page parsing");
        return document;
    }



    protected void executeAllSteps(ParserJsonSchema schema){
        Document document = getDocument(schema);
        getNextStep(schema.getStep(), document);
    }

    protected Object getNextStep(ParserStep step, Document document){
        Object parsedTempObject = getReturnedValue(step, document);
        if (step.getNextStep()!=null) {
             getNextStep(step.getNextStep(), parsedTempObject);
        }
    }

    protected Object getNextStep(ParserStep step, Object object){
        Object parsedTempObject = getReturnedValue(step, object);
        if (step.getNextStep()!=null) {
            getNextStep(step.getNextStep(), parsedTempObject);
        }
    }
    
    protected Object getReturnedValue(ParserStep step, Document document){
        Object elements = null;
        switch (step.getParseType()){
            case CLASS: elements = getReturnedValueByReturnedEntityForClass(step, document);
            break;
            case ATTRIBUTE: elements = getReturnedValueByReturnedEntityForAttr(step, document);
            break;
        }
        return elements;
    }

    protected Object getReturnedValueByReturnedEntityForClass(ParserStep step, Document document){
        Object result = null;
        switch (step.getReturnedEntity()){
            case LISTOFELEMENTS: result = document.getElementsByClass(step.getParseValue());
            break;
            case ELEMENT: result =  document.getElementsByClass(step.getParseValue()).first();
            break;
            case VALUE: result = document.getElementsByClass(step.getParseValue()).first().text();
            break;
           // case DOCUMENT: result = driver.get();
        }
      return result;
    }
    protected Object getReturnedValueByReturnedEntityForAttr(ParserStep step, Document document){
        Object result = null;
        switch (step.getReturnedEntity()){
            case LISTOFELEMENTS: result = document.getElementsByAttribute(step.getParseValue());
                break;
            case ELEMENT: result =  document.getElementsByAttribute(step.getParseValue()).first();
                break;
            case VALUE: result = document.getElementsByAttribute(step.getParseValue()).first().text();
                break;
            // case DOCUMENT: result = driver.get();
        }
        return result;
    }
}
*/
