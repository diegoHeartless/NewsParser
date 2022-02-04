package com.newsparser.core.parser.impl;

import com.newsparser.core.parser.model.old.EachPostParserSchema;
import com.newsparser.core.parser.model.old.ParserSchema;
import org.springframework.stereotype.Component;

@Component
public class RiaLentaParserSchema implements ParserSchema {
    @Override
    public String getMainUrl() {
        return "https://ria.ru/lenta";
    }

    @Override
    public String getRootClass() {
        return "list";
    }

    @Override
    public String getEachElementClass() {
        return "list-item";
    }

    @Override
    public String getSubElement() {
        return "share";
    }

    @Override
    public String getTitleTag() {
        return "data-title";
    }

    @Override
    public String getHrefTag() {
        return "data-url";
    }
    @Override
    public String getInfoTags(){
        return "list-tag";
    }

    @Override
    public EachPostParserSchema getEachPostParserSchema() {
        return new RiaLentaEachPostParserSchema();
    }

    @Override
    public ParserType getParserType() {
        return ParserType.RIA;
    }
}
