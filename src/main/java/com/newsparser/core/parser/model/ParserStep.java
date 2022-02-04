package com.newsparser.core.parser.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.newsparser.core.parser.model.enumtype.ParsBy;
import com.newsparser.core.parser.model.enumtype.ParseType;
import com.newsparser.core.parser.model.enumtype.StepType;
import com.newsparser.core.parser.model.old.ReturnedEntity;
import lombok.Data;
import lombok.ToString;
import org.springframework.util.Assert;


import javax.annotation.PostConstruct;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@ToString
public class ParserStep  {
    StepModel model;
    ParserStep nextStep;
    ParsBy parsBy;
    ParseTypeValue typeValue;

}
