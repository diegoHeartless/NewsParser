package com.newsparser.core.parser.model.old;

import com.newsparser.core.parser.model.enumtype.ParseWith;
import com.newsparser.core.parser.model.ParserStep;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ParserJsonSchema {
    ParserStep step;
    String mainUrl;
    ParseWith parsBy;
}
