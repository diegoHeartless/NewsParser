/*
package com.newsparser.core.parser;

import com.newsparser.core.parser.model.ParserStep;
import com.newsparser.core.parser.model.enumtype.StepType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class StepTypeService {

    ParserStepExecutor executor;

    @Autowired
    public StepTypeService(ParserStepExecutor executor) {
        this.executor = executor;
    }

    public Object runStep(ParserStep step, List<String> temp){
        StepResult result = new StepResult();
        validation(step);
        switch (step.getModel().getActionType()){
            case REQUEST: {

            }
            case PARSE: {

            }
            case SAVE: {

            }
        }
    }

    public void validation(ParserStep step){
        if (step.getModel().getActionType().equals(StepType.ActionType.PARSE)){
            Assert.isTrue(step.getTypeValue().getParseType() != null, "For action Parse - parse type must not be null");
        } else {
            Assert.isTrue(step.getTypeValue().getParseType() == null, "test");
        }
    }
}
*/
