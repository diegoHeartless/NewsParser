package com.newsparser.core.parser.impl;

import com.newsparser.core.parser.model.EachPostParserSchema;

public class RiaLentaEachPostParserSchema implements EachPostParserSchema {
    @Override
    public String getMainPostClass() {
        return "article__body js-mediator-article mia-analytics";
    }

    @Override
    public String getArticlesClass() {
        return "article__text";
    }
}
