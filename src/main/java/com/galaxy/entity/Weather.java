/**
 * 
 */
package com.galaxy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.galaxy.data.WeatherTypeEnum;

/**
 * @author Kelvyns
 *
 */
@Entity
public class Weather {
	
	@Id @GeneratedValue
	public Long id;
	
	public WeatherTypeEnum weatherType;
	public double perimeter;
	public Integer day;
	
	public Weather() {
	}
	/**
	 * @param type
	 * @param area
	 * @param day
	 */
	public Weather(WeatherTypeEnum type, double perimeter, Integer day) {
		this.weatherType = type;
		this.perimeter = perimeter;
		this.day = day;
	}
	/**
	 * @return the type
	 */
	public WeatherTypeEnum getWeatherType() {
		return weatherType;
	}
	/**
	 * @return the perimeter
	 */
	public double getPerimeter() {
		return perimeter;
	}
	/**
	 * @return the day
	 */
	public Integer getDay() {
		return day;
	}
	
	@Override
	public String toString() {
		return "Weather [id=" + id + ", type=" + weatherType + ", perimeter="
				+ perimeter + ", day=" + day + "]";
	}
	
}