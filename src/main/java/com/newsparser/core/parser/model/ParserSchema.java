package com.newsparser.core.parser.model;

import com.newsparser.core.parser.impl.ParserType;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ParserSchema {
    String getMainUrl();
    String getRootClass();
    String getEachElementClass();
    String getSubElement();
    String getTitleTag();
    String getHrefTag();
    String getInfoTags();
    EachPostParserSchema getEachPostParserSchema();
    ParserType getParserType();
}
