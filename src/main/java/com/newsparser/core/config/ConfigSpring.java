package com.newsparser.core.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newsparser.core.parser.model.old.ParserJsonSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.text.SimpleDateFormat;
import java.util.List;


@Configuration
public class ConfigSpring {
    @Bean
    SimpleDateFormat getDateFormatter(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    @Bean
    public RestTemplate getRestTemplate(){
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("50.114.128.23", 3128));
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setProxy(proxy);
        return new RestTemplate(requestFactory);
    }

    @Bean
    public List<ParserJsonSchema> getParsers(){
        ObjectMapper mapper = new ObjectMapper();
        List<ParserJsonSchema> parsers = null;
        try {
            InputStream stream = getClass().getClassLoader().getResourceAsStream("parser.json");
             parsers = mapper.readValue(stream,  new TypeReference<List<ParserJsonSchema>>(){});
            System.out.println(parsers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parsers;
    }
}

