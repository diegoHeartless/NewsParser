package com.newsparser.core.parser.model;

import com.newsparser.core.parser.model.enumtype.ParseType;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ParseTypeValue {
    ParseType parseType;
    String parseValue;
}
