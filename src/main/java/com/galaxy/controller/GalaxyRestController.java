package com.galaxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.entity.Response;
import com.galaxy.entity.ResponseWeather;
import com.galaxy.exception.BusinessException;
import com.galaxy.service.GalaxyService;

/**
 * @author Kelvyns
 *
 */
@RestController
public class GalaxyRestController {
	
	@Autowired
	GalaxyService galaxyService;

	@RequestMapping("/initializeGalaxy")
	Response initializeGalaxy(
			@RequestParam(value = "precision", required = false, defaultValue = "1") Integer precision,
			@RequestParam(value = "destroy", required = false, defaultValue = "0") Integer destroy) throws BusinessException {
		try {
			
			if(precision < 0 || precision > 3){
				return BusinessException.init(BusinessException.INI_PRECISION).getResponde();
			}
			if(destroy < 0 || destroy > 1){
				return BusinessException.init(BusinessException.INI_DESTROY).getResponde();
			}
			
			return galaxyService.initializeGalaxy(precision, destroy);
		} catch (Exception e) {
			e.printStackTrace();
			throw BusinessException.init(BusinessException.INI_ERROR);
		}
		
	}
	
	@RequestMapping("/periodos")
	Integer getPeriods(@RequestParam(value="tipo", required=true) String type) throws BusinessException{
		if(type != null && !type.isEmpty()) {
			switch (type.toLowerCase()) {
	        case "sequia":
	            return galaxyService.getDroughtDays();
	        case "lluvia":
	        	return galaxyService.getRainDays();
	        case "nollueve":
	        	return galaxyService.getNotRainDays();
	        case "optimo":
	        	return galaxyService.getOptimalDays();
			}
		}
		throw BusinessException.init(BusinessException.PERIODS);
	}
	
	@RequestMapping("/clima")
	ResponseWeather getWeather(@RequestParam(value="dia", required=true) Integer day) throws BusinessException{
		if(day==null || day<0 || day>3650 ){
			throw BusinessException.init(BusinessException.WEATHER);
		}
		return galaxyService.getWeather(day);
	}
	
	@RequestMapping("/diaMasLluvioso")
	ResponseWeather getDayWithMaxRain(){
		return galaxyService.getDayWithMaxRain();
	}

}
