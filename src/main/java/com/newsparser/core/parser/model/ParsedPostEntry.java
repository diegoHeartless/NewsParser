package com.newsparser.core.parser.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode(exclude = {"_id", "createdAt", "articles", "fullParseSuccess"})
public class ParsedPostEntry {
    String _id;
    String title;
    String href;
    String date;
    boolean fullParseSuccess;
    String createdAt;
    List<String> tags;
    List<String> articles;

    public void addTagToList(String tag){
        if (tags == null){
            tags = new ArrayList<>();
        }
        tags.add(tag);
    }

    public void addArticleToList(String article){
        if (articles == null){
            articles = new ArrayList<>();
        }
        articles.add(article);
    }
}
