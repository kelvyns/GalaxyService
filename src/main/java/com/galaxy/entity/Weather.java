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
	private Long id;
	
	private WeatherTypeEnum type;
	private double perimeter;
	private Integer day;
	
	/**
	 * @param type
	 * @param area
	 * @param day
	 */
	public Weather(WeatherTypeEnum type, double perimeter, Integer day) {
		this.type = type;
		this.perimeter = perimeter;
		this.day = day;
	}
	/**
	 * @return the type
	 */
	public WeatherTypeEnum getType() {
		return type;
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
		return "Weather [id=" + id + ", type=" + type + ", perimeter="
				+ perimeter + ", day=" + day + "]";
	}
	
}