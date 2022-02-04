package com.newsparser.core.parser.model;

import org.springframework.stereotype.Service;

@Service
public class TypeService<T> {
    public T getResult(Object result){
        return (T) result;
    }
}
