package com.newsparser.core.parser.impl;

import com.newsparser.core.parser.model.old.EachPostParserSchema;
import com.newsparser.core.parser.model.old.ParserSchema;


public class CianParserSchema implements ParserSchema {

    @Override
    public String getMainUrl() {
        return "https://voronezh.cian.ru/cat.php?deal_type=sale&engine_version=2&house[0]=1917454&house[1]=1774058&offer_type=flat&room1=1&room2=1&room3=1&room4=1";
    }

    @Override
    public String getRootClass() {
        return "cell-list__item-info";
    }

    @Override
    public String getEachElementClass() {
        return "share";
    }

    @Override
    public String getSubElement() {
        return null;
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
    public String getInfoTags() {
        return null;
    }

    @Override
    public EachPostParserSchema getEachPostParserSchema() {
        return null;
    }

    @Override
    public ParserType getParserType() {
        return null;
    }

}
