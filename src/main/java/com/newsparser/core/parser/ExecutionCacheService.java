package com.newsparser.core.parser;

import com.newsparser.core.parser.model.StepModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ExecutionCacheService {
    private Map<String, ExecutionContext> cache;

    public ExecutionCacheService() {
        this.cache = new ConcurrentHashMap<>();
    }

    public String addCacheEntity(ExecutionContext context){
        String uuid =  UUID.randomUUID().toString();
        cache.put(uuid, context);
        return uuid;
    }
    public void removeCache(String uuid){
        cache.remove(uuid);
    }
    public ExecutionContext getCache(String uuid){
       return cache.get(uuid);
    }
    public Queue<StepModel> getCacheSteps(String uuid){
        return cache.get(uuid).getSteps();
    }
}
