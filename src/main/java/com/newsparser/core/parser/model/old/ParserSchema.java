package com.newsparser.core.parser.model.old;

import com.newsparser.core.parser.impl.ParserType;
import com.newsparser.core.parser.model.old.EachPostParserSchema;

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
