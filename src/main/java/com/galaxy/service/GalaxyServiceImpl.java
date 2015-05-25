package com.galaxy.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.galaxy.entity.Response;
import com.galaxy.entity.ResponseWeather;
import com.galaxy.entity.Weather;
import com.galaxy.manager.GalaxyManager;


/**
 * @author Kelvyns
 *
 */
public class GalaxyServiceImpl implements GalaxyService {

	private static final long serialVersionUID = 7003801873234325840L;
	
	@Autowired
	GalaxyManager galaxyManager;

	@Override
	public Response initializeGalaxy(Integer precision) {
		Boolean update = galaxyManager.initializeGalaxy(precision);
		if(Boolean.TRUE.equals(update)){
			return new Response(Response.OK, "Sucess");
		}else {
			return new Response(Response.FAIL, "Failed");
		}
	}

	@Override
	public ResponseWeather getWeather(Integer day) {
		Weather weather = galaxyManager.getWeather(day);
		ResponseWeather responseWeather = new ResponseWeather(weather.getDay(), weather.getType().type());
		return responseWeather;
	}

	@Override
	public Integer getDroughtDays() {
		return galaxyManager.getDroughtDays();
	}

	@Override
	public Integer getRainDays() {
		return galaxyManager.getRainDays();
	}

	@Override
	public ResponseWeather getDayWithMaxRain() {
		Weather weather = galaxyManager.getDayWithMaxRain();
		ResponseWeather responseWeather = new ResponseWeather(weather.getDay(), weather.getType().type());
		return responseWeather;
	}

	@Override
	public Integer getOptimalDays() {
		return galaxyManager.getOptimalDays();
	}

	@Override
	public Integer getNotRainDays() {
		return galaxyManager.getNotRainDays();
	}
}
