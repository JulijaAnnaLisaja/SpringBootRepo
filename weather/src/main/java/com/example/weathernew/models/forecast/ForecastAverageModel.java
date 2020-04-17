package com.example.weathernew.models.forecast;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Getter
@Setter
public class ForecastAverageModel implements Serializable {

    private static final long serialVersionUID = 5763148931413501367L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    private BigDecimal daily;
    private BigDecimal nightly;
    private BigDecimal pressure;
    @JsonIgnore
    private BigDecimal totalDaily;
    @JsonIgnore
    private Integer averageDaily;
    @JsonIgnore
    private BigDecimal totalNightly;
    @JsonIgnore
    private Integer averageNightly;
    @JsonIgnore
    private BigDecimal totalPressure;
    @JsonIgnore
    private Integer averagePressure;

    public ForecastAverageModel() {
        this.totalDaily = BigDecimal.ZERO;
        this.totalNightly = BigDecimal.ZERO;
        this.totalPressure = BigDecimal.ZERO;
        this.averageDaily = 0;
        this.averageNightly = 0;
        this.averagePressure = 0;
    }

    public void plusMap(ForecastMapTimeModel map) {
        if (map.isDaily()) {
            this.totalDaily = this.totalDaily.add(map.getMain().getTemp());
            this.averageDaily++;
        } else {
            this.totalNightly = this.totalNightly.add(map.getMain().getTemp());
            this.averageNightly++;
        }
        this.totalPressure = this.totalPressure.add(map.getMain().getTemp());
        this.averagePressure++;
    }

    public void totalize() {
        this.daily = (this.averageDaily > 0)
                ? this.totalDaily.divide(new BigDecimal(this.averageDaily.toString()), 2, RoundingMode.HALF_UP)
                : null;
        this.nightly = (this.averageNightly > 0)
                ? this.totalNightly.divide(new BigDecimal(this.averageNightly.toString()), 2, RoundingMode.HALF_UP)
                : null;
        this.pressure = (this.averagePressure > 0)
                ? this.totalPressure.divide(new BigDecimal(this.averagePressure.toString()), 2, RoundingMode.HALF_UP)
                : null;
    }

}
