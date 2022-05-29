/*
package com.newsparser.core.parser;

import com.newsparser.core.parser.model.ParserStep;
import com.newsparser.core.parser.model.enumtype.StepType;
import org.jsoup.Jsoup;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.io.IOException;

import static com.newsparser.core.parser.model.enumtype.StepType.ReturnType.VALUE;

public class ActionRequestService {
    WebDriver driver;

    @Autowired
    public ActionRequestService(WebDriver driver) {
        this.driver = driver;
    }

    public Object runRequestStep(ParserStep step, StepResult result){

        switch (step.getModel().getInputType()){
            case VALUE: {
                 result = goToPage(step, result, VALUE);
            }
        }
    }

    public StepResult goToPage(ParserStep step, StepResult result, StepType.ReturnType type) {
      //  Document document = null;
        switch (step.getParsBy()){
            case JSOUP:
                try {
                    result.setResult(Jsoup.connect(step.getTypeValue().getParseValue()).get());
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                break;
            case PHANTOM:
                driver.get(step.getTypeValue().getParseValue());
                result.setResult(Jsoup.parse(driver.getPageSource()));
                break;
        }
        Assert.notNull(result.getResult(), "Error during main page parsing");
        return result;
    }
}
*/
