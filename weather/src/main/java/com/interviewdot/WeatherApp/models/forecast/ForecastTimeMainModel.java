package com.interviewdot.WeatherApp.models.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@ApiModel(description="Main entity of Forecast Model class")
@Entity
public class ForecastTimeMainModel {
	@Id
	@GeneratedValue
	private Integer id;

	private BigDecimal temp;

	/**
	 * Ieva, please, rename all of this variable
	 * with @JsonProperty method, so
	 * it matches the Java camelCase standards
	 * Thanks
	 */
	@JsonProperty("temp_min")
	private BigDecimal tempMin;
	@JsonProperty("temp_max")
	private BigDecimal tempMax;
	private BigDecimal pressure;
	private BigDecimal sea_level;
	private BigDecimal grnd_level;
	private BigDecimal humidity;
	private BigDecimal temp_kf;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getTemp() {
		return temp;
	}

	public void setTemp(BigDecimal temp) {
		this.temp = temp;
	}

	public BigDecimal getTempMin() {
		return tempMin;
	}

	public void setTempMin(BigDecimal tempMin) {
		this.tempMin = tempMin;
	}

	public BigDecimal getTempMax() {
		return tempMax;
	}

	public void setTempMax(BigDecimal tempMax) {
		this.tempMax = tempMax;
	}

	public BigDecimal getPressure() {
		return pressure;
	}

	public void setPressure(BigDecimal pressure) {
		this.pressure = pressure;
	}

	public BigDecimal getSea_level() {
		return sea_level;
	}

	public void setSea_level(BigDecimal sea_level) {
		this.sea_level = sea_level;
	}

	public BigDecimal getGrnd_level() {
		return grnd_level;
	}

	public void setGrnd_level(BigDecimal grnd_level) {
		this.grnd_level = grnd_level;
	}

	public BigDecimal getHumidity() {
		return humidity;
	}

	public void setHumidity(BigDecimal humidity) {
		this.humidity = humidity;
	}

	public BigDecimal getTemp_kf() {
		return temp_kf;
	}

	public void setTemp_kf(BigDecimal temp_kf) {
		this.temp_kf = temp_kf;
	}

}
