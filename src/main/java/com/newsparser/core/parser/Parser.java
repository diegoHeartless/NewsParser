package com.newsparser.core.parser;

import com.newsparser.core.exception.NewsParserException;
import com.newsparser.core.parser.model.ParsedPostEntry;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public interface Parser {

    List<ParsedPostEntry> getPostListFromUrl() throws IOException, NewsParserException;

    List<ParsedPostEntry> parseEachLink(List<ParsedPostEntry> existedPosts) throws IOException;

}
