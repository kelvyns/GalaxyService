package com.galaxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.galaxy.entity.Response;
import com.galaxy.entity.ResponseWeather;
import com.galaxy.entity.Weather;
import com.galaxy.manager.GalaxyManager;


/**
 * @author Kelvyns
 *
 */
@Component
public class GalaxyServiceImpl implements GalaxyService {

	private static final long serialVersionUID = 7003801873234325840L;
	
	public GalaxyServiceImpl() {
	}
	
	@Autowired
	GalaxyManager galaxyManager;
	
	@Override
	public Response initializeGalaxy(Integer precision, Integer destroy) {
		Boolean update = galaxyManager.initializeGalaxy(precision, destroy);
		if(Boolean.TRUE.equals(update)){
			return new Response(Response.OK, "Success");
		}else {
			return new Response(Response.FAIL, "Failed");
		}
	}

	@Override
	public ResponseWeather getWeather(Integer day) {
		Weather weather = galaxyManager.getWeather(day);
		ResponseWeather responseWeather = new ResponseWeather(weather.getDay(), weather.getWeatherType().type());
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
		return new ResponseWeather(weather.getDay(), "El dia que mas llueve");
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
