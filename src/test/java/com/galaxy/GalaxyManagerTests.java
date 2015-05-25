package com.galaxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.galaxy.manager.GalaxyManager;
import com.galaxy.manager.GalaxyManagerImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GalaxyManagerImpl.class)
@WebAppConfiguration
public class GalaxyManagerTests {
	
	@Autowired
	private GalaxyManager galaxyManager;
	
	//@Autowired
	//private WeatherRepository weatherRepository;

	@Test
	public void contextLoads() {
		
		Integer precision = 1;
		//galaxyManager.initializeGalaxy(precision);
		
	}

}
