package com.newsparser.core.rewriter;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;


@Service
public class RewriterService {


    public String sendRequest(String text) throws IOException, InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Requested-With",  "XMLHttpRequest");
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("method", "getSynText");
        map.add("text", text);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        String fooResourceUrl
                = "https://rustxt.ru/api/index.php";
        String response
                = restTemplate.postForObject(fooResourceUrl, request, String.class);
        System.out.println(response.toString());
        return response.toString();
    }
}
