package com.newsparser.core.translate;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TranslateEntity {
   String client;
   String sl;
   String tl;
   String dt;
   String q;

    public TranslateEntity(String client, String sl, String tl, String dt, String q) {
        this.client = "gtx";
        this.sl = sl;
        this.tl = tl;
        this.dt = dt;
        this.q = q;
    }
}
