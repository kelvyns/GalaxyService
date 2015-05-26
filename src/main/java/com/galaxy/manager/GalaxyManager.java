package com.galaxy.manager;

import java.io.Serializable;

import com.galaxy.entity.Weather;


/**
 * @author Kelvyns
 *
 */
public interface GalaxyManager extends Serializable{
	
	public Boolean initializeGalaxy(Integer precision, Integer destroy);
	public Weather getWeather(Integer day);
	public Integer getDroughtDays();
	public Integer getRainDays();
	public Weather getDayWithMaxRain();
	public Integer getOptimalDays();
	public Integer getNotRainDays();

}
