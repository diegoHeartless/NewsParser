package com.newsparser.core.rewriter;




import org.springframework.http.*;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.xml.Jaxb2XmlDecoder;
import org.springframework.http.codec.xml.Jaxb2XmlEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
//import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

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
