package com.newsparser.core.config;

import ch.qos.logback.core.util.DatePatternToRegexUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.text.SimpleDateFormat;


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
}

