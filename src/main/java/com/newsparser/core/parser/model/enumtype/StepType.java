package com.newsparser.core.parser.model.enumtype;

public class StepType {
    public static enum ReturnType{
        ELEMENT,
        ELEMENTS,
        VALUE,
        LIST_OF_VALUES,
        DOC
    }
    public static enum ActionType{
        REQUEST,
        SAVE,
        PARSE
    }
    public static enum InputType{
        VALUE,
        LIST_OF_VALUES,
        ELEMENT,
        LIST_OF_ELEMENTS,
        DOC,
        NULL
    }
}
