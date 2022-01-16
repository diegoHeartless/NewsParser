package com.newsparser.core.rewriter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RewriterApiEntity {
    String method;
   // Integer strength;
    String text;
   // String rewrite;
   // Double similarity;

    public RewriterApiEntity(String text) {
        this.method = "getSynText";
        //this.strength = 3;
        this.text = text;
    }

    public RewriterApiEntity(String language, String rewrite, Double similarity) {
      //  this.language = language;
     //   this.rewrite = rewrite;
     //   this.similarity = similarity;
    }
}
