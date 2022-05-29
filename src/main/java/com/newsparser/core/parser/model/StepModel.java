package com.newsparser.core.parser.model;

import com.newsparser.core.parser.model.enumtype.ParseWith;
import com.newsparser.core.parser.model.enumtype.ParseType;
import com.newsparser.core.parser.model.enumtype.StepType.*;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class StepModel {
    Integer stepId;
    Action action;
    ParseWith parseWith;
    InputType inputType;
    String saveAsField;
    boolean returnInput;
    ReturnType returnType;

    @Data
    public class Action{
          ActionType type;
          String value;
          ParseType parseBy;
    }
    public static enum ActionType{
        REQUEST,
        SAVE,
        PARSE
    }
}
