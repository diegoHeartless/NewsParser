package com.newsparser.core.rewriter;

import lombok.Data;

@Data
public class RewriterApiResponse {
    String modified_text;
    Float percent_unique;
    Integer count_replace;
    Integer count_symbol;
    Float time;
}
