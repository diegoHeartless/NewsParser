package com.newsparser.core.parser.model;

import com.newsparser.core.parser.model.enumtype.StepType.*;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class StepModel {
    InputType inputType;
    ActionType actionType;
    ReturnType returnType;
}
