package com.newsparser.core.config;

import ch.qos.logback.core.util.DatePatternToRegexUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;


@Configuration
public class ConfigSpring {
    @Bean
    SimpleDateFormat getDateFormatter(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}

