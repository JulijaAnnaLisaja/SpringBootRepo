package com.example.weathernew.models.forecast;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@JacksonXmlRootElement(localName = "weather")
@Getter
@Setter
public class ForecastMessageModel implements Serializable {

    private static final long serialVersionUID = 1253320017739887653L;

    private String cod;
    private BigDecimal message;
    private Integer cnt;

    @JacksonXmlProperty(localName = "list")
    @JacksonXmlElementWrapper(localName = "list", useWrapping = true)
    private List<ForecastMapTimeModel> list;

}
