package com.galaxy.data;


/**
 * @author Kelvyns
 *
 */
public enum WeatherTypeEnum {
	DROUDHT   ("Sequia"),
	RAIN   ("Llueve"),
	NOTRAIN   ("No llueve"),
	OPTIMUM ("Optimo");
	
	private final String type;
	
	private WeatherTypeEnum(String type) {
		this.type = type;
	}
	
	public String type() {
		return this.type;
	}
	
}
