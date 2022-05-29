package com.newsparser.core.parser.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.newsparser.core.parser.model.enumtype.ParseWith;
import lombok.Data;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@ToString
public class ParserStep  {
    StepModel model;
    ParserStep nextStep;
    ParseWith parsBy;
    ParseTypeValue typeValue;

}
