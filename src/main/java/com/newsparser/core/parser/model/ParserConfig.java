package com.newsparser.core.parser.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class ParserConfig {
    JsonNode model;
    List<StepModel> steps;
}
