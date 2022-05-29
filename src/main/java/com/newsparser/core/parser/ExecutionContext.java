package com.newsparser.core.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.newsparser.core.parser.model.ParserTempMap;
import com.newsparser.core.parser.model.StepModel;
import lombok.Data;
import org.seleniumhq.jetty7.util.ArrayQueue;

import java.util.List;
import java.util.Queue;

@Data
public class ExecutionContext {
    private ParserTempMap tempMap;
    private Queue<StepModel> steps;
    private List<JsonNode> result;

    public ExecutionContext(ParserTempMap tempMap, Queue<StepModel> steps) {
        this.tempMap = tempMap;
        this.steps = steps;
    }
    public String addObjectToMap(Object obj){
       return tempMap.addObjectToMap(obj);
    }
    public Object getObject(String uuid){
        return this.tempMap.getObject(uuid);
    }
}
