/*
package com.newsparser.core.translate;

import com.newsparser.core.arango.NewsArangoRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class TranslateService {

    RestTemplate restTemplate;

    Map<String, String> dist = new LinkedHashMap<>();
    String url = "https://translate.googleapis.com/translate_a/single";

    NewsArangoRepository arangoRepository;

    ChromeDriver driver;

    @Autowired
    public TranslateService(RestTemplate restTemplate, NewsArangoRepository arangoRepository, ChromeDriver driver) {
        this.restTemplate = restTemplate;
        this.arangoRepository = arangoRepository;
        this.driver = driver;
    }

    @PostConstruct
    public void init(){
        dist.put("ru", "en");
     //   dist.put("zh", "pa");
     //   dist.put("pa", "ru");
     //   dist.put("gu", "zh");
      //  dist.put("zh", "ru");
    }
   */
/* @Scheduled(fixedDelay = 60000)
    public void rewritePost(){
        arangoRepository.getExistedPosts().forEach(post -> rewrite(post.getArticles().get(0)));
    }*//*


  */
/*  public void rewrite(String text)  {
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent",  "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.47 Safari/537.36");

        List<String> result = new ArrayList<>();

        dist.forEach((key, value) -> {
            String temp = text;

            try {
                String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                        .queryParam("client", "gtx")
                        .queryParam("sl", key)
                        .queryParam("tl", value)
                        .queryParam("dt", "t")
                        .queryParam("q", temp)
                        .encode()
                        .toUriString();
                driver.get(urlTemplate);
                DevTools chromeDevTools = driver.getDevTools();
                chromeDevTools.createSession();
                chromeDevTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
                chromeDevTools.addListener(Network.loadingFinished(),
                        entry -> {
                            System.out.println("Body: " + chromeDevTools.send(Network.getResponseBody(entry.getRequestId())).getBody());
                        });
              *//*
*/
/*  ResponseEntity<String> response
                        = restTemplate.getForEntity(urlTemplate, String.class, headers);*//*
*/
/*
                System.out.println(driver);
               // temp = driver..split("\"")[3];
                if (value.equals("en")) {
                    result.add(temp);
                }
            }catch (HttpClientErrorException | ResourceAccessException e){
                String urlcontenttool = "https://contenttool.io/.netlify/functions/paraphrase/";
                String urlTemplate = UriComponentsBuilder.fromHttpUrl(urlcontenttool)
                        .queryParam("baselocalecode", key)
                        .queryParam("datalanguagecode", value)
                        .queryParam("value", temp)
                        .encode()
                        .toUriString();
                ResponseEntity<String> response
                        = null;
                try {
                    response = restTemplate.getForEntity(urlTemplate, String.class, headers);
                    temp = response.getBody().split("\"")[3];
                    if (value.equals("en")) {
                        result.add(temp);
                    }
                } catch (RestClientException restClientException) {
                    restClientException.printStackTrace();
                }

            }

            try {
                System.out.println("wait");
                Thread.sleep(2000);
                System.out.println("wait over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

     //   HttpEntity< MultiValueMap<String, Object>> request = new HttpEntity< MultiValueMap<String, Object>>(map, headers);

      //  HttpEntity<TranslateEntity> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        System.out.println(text);
       // System.out.println(response);
       // System.out.println(response);
        try {
            if (!result.isEmpty())System.out.println(URLDecoder.decode(result.get(0), StandardCharsets.UTF_8.name()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }*//*

}
*/
