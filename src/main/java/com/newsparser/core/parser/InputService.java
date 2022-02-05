package com.newsparser.core.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeCreator;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.newsparser.core.parser.model.ParserStep;
import org.springframework.stereotype.Service;

@Service
public class InputService {
    public Object getTempObject(ParserStep step){

        ObjectNode node = new ObjectNode(JsonNodeFactory.instance);
        node.putArray()
    }
}
