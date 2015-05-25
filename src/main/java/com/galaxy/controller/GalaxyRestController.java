package com.galaxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.entity.Response;
import com.galaxy.entity.ResponseWeather;
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
	Response initializeGalaxy(@RequestParam(value="precision", required=false, defaultValue="1") Integer precision) {
		Integer prec;
		try{
			prec = Integer.valueOf(precision);
		} catch (Exception e) {
			prec = new Integer(1);
		};
		return galaxyService.initializeGalaxy(prec);
	}
	
	@RequestMapping("/getDroughtDays")
	Integer getDroughtDays(){
		return galaxyService.getDroughtDays();
	}
	
	@RequestMapping("/getRainDays")
	Integer getRainDays(){
		return galaxyService.getRainDays();
	}
	
	@RequestMapping("/getOptimalDays")
	Integer getOptimalDays(){
		return galaxyService.getOptimalDays();
	}
	
	@RequestMapping("/getNotRainDays")
	Integer getNotRainDays(){
		return galaxyService.getNotRainDays();
	}
	
	@RequestMapping("/getWeather")
	ResponseWeather getWeather(@RequestParam(value="day", required=true) Integer day){
		return galaxyService.getWeather(day);
	}
	
	@RequestMapping("/getDayWithMaxRain")
	ResponseWeather getDayWithMaxRain(){
		return galaxyService.getDayWithMaxRain();
	}

}
