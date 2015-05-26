package com.galaxy.manager;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.galaxy.data.PlanetEnum;
import com.galaxy.data.WeatherTypeEnum;
import com.galaxy.entity.Coordinate;
import com.galaxy.entity.Planet;
import com.galaxy.entity.Weather;
import com.galaxy.repository.WeatherRepository;
import com.galaxy.util.Util;

/**
 * @author Kelvyns
 *
 */
@Component  
public class GalaxyManagerImpl implements GalaxyManager {

	private static final long serialVersionUID = -443631228566715847L;
	
	private static final Logger logger = Logger.getLogger(GalaxyManagerImpl.class);
	
	public GalaxyManagerImpl() {
	}
	
	@Autowired
	public WeatherRepository weatherRepository;
	
	public void setWeatherRepository(WeatherRepository weatherRepository) {
		this.weatherRepository = weatherRepository;
	}
	
	private Planet vulcano = new Planet(PlanetEnum.VULCANO.radius(),
			PlanetEnum.VULCANO.velocity(), PlanetEnum.VULCANO.direction());
	private Planet ferengi = new Planet(PlanetEnum.FERENGI.radius(),
			PlanetEnum.FERENGI.velocity(), PlanetEnum.FERENGI.direction());
	private Planet betasoide = new Planet(PlanetEnum.BETASOIDE.radius(),
			PlanetEnum.BETASOIDE.velocity(), PlanetEnum.BETASOIDE.direction());
	
	private final double[] SUN = {0,0};
	
	private void createGalaxy(int precision, Integer destroy) {
		
		if(!checkGalaxy(destroy)){
			int totalDays=365*10;
			int day = 0;
			for (int i = 0; i <= totalDays; i++) {
				logger.debug("DIA: "+ i);
				day = i;
				interactionGalaxy( day, precision );
			}
		}
		
	}
	
	private boolean checkGalaxy(Integer destroy) {
		if(weatherRepository.count()>0){
			if(destroy == 1){
				weatherRepository.deleteAll();
			}
			return true;
		}
		return false;
	}

	private void interactionGalaxy(int day, int precision){
		
		logger.debug("Loanding the GALAXY ...");
		loadGalaxy(day);
		if(areThePointsAlined(precision)){
			
			logger.debug("The planets form a line	");
			if(isSunAlinedWithPlanets(precision)){
				logger.debug("The planets are in line with the SUN");
				 weatherRepository.save(new Weather(WeatherTypeEnum.DROUDHT, 0, day));
			} else {
				logger.debug("The planets are not in line with the SUN");
				weatherRepository.save(new Weather(WeatherTypeEnum.OPTIMUM, 0, day));

			}
		}else {
			
			logger.debug("The planets form a triangle");
			if(isSunInTheTriangle()){
				logger.debug("The SUN is in the triangle");
				double perimeter = Util.trianglePerimeter(vulcano.getXY(), ferengi.getXY(), betasoide.getXY());
				weatherRepository.save(new Weather(WeatherTypeEnum.RAIN, perimeter, day));
			} else {
				weatherRepository.save(new Weather(WeatherTypeEnum.NOTRAIN, 0, day));
				logger.debug("The SUN is out the triangle");
			}
		}	
	}
	
	private boolean isSunAlinedWithPlanets(int precision){
		boolean op1 = Util.areThePointsAlined(SUN, ferengi.getXY(), betasoide.getXY(), precision);
		boolean op2 = Util.areThePointsAlined(SUN, vulcano.getXY(), ferengi.getXY(), precision);
		return op1 && op2;
	}
	
	private boolean areThePointsAlined (int precision) {
		return Util.areThePointsAlined( betasoide.getXY(), vulcano.getXY(), ferengi.getXY(), precision);
	}
	
	private boolean isSunInTheTriangle(){
		return Util.triangleInPointByOrientation(ferengi.getXY(), vulcano.getXY(), betasoide.getXY(), SUN);
	}

	private void loadGalaxy(int day) {
		// Put in the plane the planets
		setCoordinate(day);
		logger.debug("Vulcano, Ferengi, Betasoide");
		logger.debug(vulcano.getCoordinate().toString());
		logger.debug(ferengi.getCoordinate().toString());
		logger.debug(betasoide.getCoordinate().toString());
	}
	
	private void setCoordinate(int day) {
		vulcano.setCoordinate(new Coordinate(vulcano, day));
		ferengi.setCoordinate(new Coordinate(ferengi, day));
		betasoide.setCoordinate(new Coordinate(betasoide, day));
		
	}
	
	private Integer findByWeather(WeatherTypeEnum weatherTypeEnum){
		try {
			Collection<Weather> weatherColl = weatherRepository.findByWeatherType(weatherTypeEnum);
			return weatherColl.size();
		} catch(Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Boolean initializeGalaxy(Integer precision, Integer destroy) {
		logger.debug("initializeGalaxy");
		try {
			createGalaxy(precision, destroy);
		} catch(Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
	
	@Override
	public Weather getWeather(Integer day) {
		try {
			return weatherRepository.findByDay(day);
		} catch(Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Integer getDroughtDays() {
		return findByWeather(WeatherTypeEnum.DROUDHT);
	}
	
	@Override
	public Integer getRainDays() {
		return findByWeather(WeatherTypeEnum.RAIN);
	}
	
	@Override
	public Weather getDayWithMaxRain() {
		try {
			Collection<Weather> weatherColl = weatherRepository.findByWeatherType(WeatherTypeEnum.RAIN);
			if(weatherColl!=null && weatherColl.size()>0){
				Weather weatherMax = new Weather(WeatherTypeEnum.RAIN, 0.0, 0);
				for (Weather weather : weatherColl) {
					if( weatherMax.getPerimeter() < weather.getPerimeter() ) {
						weatherMax = weather;
					}
				}
				return weatherMax;
			}else {
				return null;
			}
			
		} catch(Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Integer getOptimalDays() {
		return findByWeather(WeatherTypeEnum.OPTIMUM);
	}
	
	@Override
	public Integer getNotRainDays() {
		return findByWeather(WeatherTypeEnum.NOTRAIN);
	}
	
}
