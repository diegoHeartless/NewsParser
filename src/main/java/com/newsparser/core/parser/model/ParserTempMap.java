package com.newsparser.core.parser.model;

import lombok.Data;
import lombok.ToString;

import java.util.*;

@Data
@ToString
public class ParserTempMap {
    Map<String, Object> tempMap;

    public ParserTempMap() {
        this.tempMap = new HashMap<>();
    }

    public String addObjectToMap(Object object){
        String uuid =  UUID.randomUUID().toString();
        this.tempMap.put(uuid, object);
        return uuid;
    }

    public List<String> addObjectsToMap(List<Object> objects){
        objects.forEach(o ->  this.tempMap.put(UUID.randomUUID().toString(), o));
        return new ArrayList<>(this.tempMap.keySet());
    }

    public void removeObjectFromMap(String uuid){
        this.tempMap.remove(uuid);
    }

    public void removeObjectsToMap(List<String> uuids){
        uuids.forEach(uuid -> this.tempMap.remove(uuid));
    }
    public Object getObject(String uuid){
        return this.tempMap.get(uuid);
    }
}
