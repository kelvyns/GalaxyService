package com.galaxy.data;


/**
 * @author Kelvyns
 *
 */
public enum WeatherTypeEnum {
	DROUDHT   ("Drought"),
	RAIN   ("Rain"),
	NOTRAIN   ("Not Rain"),
	OPTIMUM ("Optomum");
	
	private final String type;
	
	private WeatherTypeEnum(String type) {
		this.type = type;
	}
	
	public String type() {
		return this.type;
	}
	
}
