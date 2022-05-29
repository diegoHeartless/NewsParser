package com.newsparser.core.parser;

import com.newsparser.core.arango.NewsArangoRepository;
//import com.newsparser.core.translate.TranslateService;
import com.newsparser.core.parser.model.ParserConfig;
import com.newsparser.core.parser.model.ParserTempMap;
import com.newsparser.core.parser.model.StepModel;
import com.newsparser.core.parser.model.enumtype.StepType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.seleniumhq.jetty7.util.ArrayQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.IOException;

@Service
public class ParsersService {

    NewsArangoRepository arangoRepository;
    WebDriver driver;
    ExecutionCacheService cacheService;

    @Autowired
    public ParsersService(NewsArangoRepository arangoRepository, WebDriver driver, ExecutionCacheService cacheService) {
        this.arangoRepository = arangoRepository;
        this.driver = driver;
        this.cacheService = cacheService;
    }

    public void updateCacheExecution(ParserConfig parser) {
        ArrayQueue<StepModel> queue = new ArrayQueue<>();
        parser.getSteps().forEach(step -> queue.add(step.getStepId() - 1, step));
        ExecutionContext context = new ExecutionContext(new ParserTempMap(), queue);
        if (context.getSteps().size() != 0) {
            String uuid = cacheService.addCacheEntity(context);
            while (context.getSteps().size() != 0) {
                uuid = runStep(uuid, null);
            }
        }
    }

    public String runStep(String contextUuid, String inputUuid) {
        ExecutionContext context = cacheService.getCache(contextUuid);
        StepModel stepModel = context.getSteps().remove();
        switch (stepModel.getAction().getType()) {
            case REQUEST:
                return context.addObjectToMap(getDoc(stepModel));
           // Assert.isTrue(stepModel.getReturnType() == StepType.ReturnType.DOC, "Request type return only DOC");
          //  break;
            case SAVE:

                break;
            case PARSE:
                Object elements = inputUuid != null ? context.getObject(inputUuid) : context.getTempMap().getTempMap().values().iterator().next();
                return context.addObjectToMap(parse(stepModel, (Elements) elements));
            default:
                return null;
        }
        return null;
    }


    public Object getDoc(StepModel stepModel) {
        switch (stepModel.getParseWith()) {
            case JSOUP:
                try {
                  Document doc =  Jsoup.connect(stepModel.getAction().getValue()).get();
                    Elements elements = doc.getElementsByClass("wer");
                    elements.get(0);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            case PHANTOM:
                driver.get(stepModel.getAction().getValue());
                return Jsoup.parse(driver.getPageSource());
            default:
                return null;
        }
    }

   /* public Object getSuitableInput(StepModel stepModel) {
        Object object = null;
        switch (stepModel.getInputType()) {
            case ELEMENT:
            case VALUE:
            case DOC:
                object= context.getTempMap().getTempMap().values().iterator().next();
                break;
            case LIST_OF_VALUES:
            case LIST_OF_ELEMENTS:
            default:
                object = context.getTempMap().getTempMap().values();
        }
        if (!stepModel.isReturnInput()) {
            context.getTempMap().getTempMap().clear();
        }
        return object;
    }*/

    public Elements parse(StepModel stepModel, Document input) {
        switch (stepModel.getAction().getParseBy()) {
            case CLASS:
                return input.getElementsByClass(stepModel.getAction().getValue());
            case ATTRIBUTE:
                return input.getElementsByAttribute(stepModel.getAction().getValue());
            default:
                return null;
        }
    }

    public Elements parse(StepModel stepModel, Elements input) {
        Elements result = new Elements();
        input.forEach(element -> {
            switch (stepModel.getAction().getParseBy()) {
                case CLASS:
                    result.addAll(element.getElementsByClass(stepModel.getAction().getValue()));
                    break;
                case ATTRIBUTE:
                    result.addAll(element.getElementsByAttribute(stepModel.getAction().getValue()));
                    break;
                default:
                    break;
            }
        });
        return result;
    }

    // @Scheduled(fixedDelay = 10000)
   /* public void runPostParsers() {
        parsers.forEach(parser -> {
            try {
                List<ParsedPostEntry> parsedPost = parser.getPostListFromUrl();
                List<ParsedPostEntry> existedPosts = arangoRepository.getExistedPosts();
                parsedPost.removeAll(existedPosts);
                if (parsedPost.size() != 0) {
                    arangoRepository.insertEntrys(parsedPost);
                    updateTags();
                }
            } catch (IOException | NewsParserException exception) {
                exception.printStackTrace();
            }
        });
    }*/

    //@Scheduled(fixedDelay = 30000)
  /*  public void runEachPostParser() throws IOException, InterruptedException {
        parsers.forEach(parser -> {
            try {
                List<ParsedPostEntry> filledPosts = parser.parseEachLink(
                        arangoRepository.getExistedPosts()
                                .stream().filter(
                                post -> !post.isFullParseSuccess())
                                .limit(5)
                                .collect(Collectors.toList()));
                System.out.println(filledPosts);
                //  filledPosts.forEach(post -> translateService.rewrite(post.getTitle()));
                arangoRepository.fillEntrys(filledPosts);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });*/
    /*  parsers.forEach(parser -> {
            List<>parser.parseEachLink();
        }*/

    //  }

    protected void updateTags() {
        arangoRepository.undateTagLinks();
    }

}
