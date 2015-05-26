package com.galaxy.service;

import java.io.Serializable;

import com.galaxy.entity.Response;
import com.galaxy.entity.ResponseWeather;


/**
 * @author Kelvyns
 *
 */
public interface GalaxyService extends Serializable{
	
	public Response initializeGalaxy(Integer prec, Integer destroy);
	public ResponseWeather getWeather(Integer day);
	public Integer getDroughtDays();
	public Integer getRainDays();
	public ResponseWeather getDayWithMaxRain();
	public Integer getOptimalDays();
	public Integer getNotRainDays();

}
