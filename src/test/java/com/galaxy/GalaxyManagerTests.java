package com.galaxy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.galaxy.entity.Weather;
import com.galaxy.manager.GalaxyManager;
import com.galaxy.manager.GalaxyManagerImpl;
import com.galaxy.repository.WeatherRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GalaxyManager.class)
@WebAppConfiguration
public class GalaxyManagerTests {
	
	@Mock
	WeatherRepository weatherRepository;

	@Before
	public void initTest(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void initializeGalaxy() {

		GalaxyManagerImpl galaxyManager = new GalaxyManagerImpl();
		galaxyManager.setWeatherRepository(weatherRepository);
		Weather weather = new Weather();
		Mockito.when(weatherRepository.count()).thenReturn((long)0);
		Mockito.when(weatherRepository.save(Mockito.any(Weather.class))).thenReturn(weather);
		Integer precision = 1;
		Integer destroy = 0;
		Boolean galaxyOk = galaxyManager.initializeGalaxy(precision, destroy);
		Mockito.verify(weatherRepository, Mockito.atLeast(3650));
		assertEquals(Boolean.TRUE, galaxyOk);
		
	}
	
	@Test
	public void detroyGalaxy() {
		
		MockitoAnnotations.initMocks(this);
		GalaxyManagerImpl galaxyManager = new GalaxyManagerImpl();
		galaxyManager.setWeatherRepository(weatherRepository);
		Mockito.when(weatherRepository.count()).thenReturn((long) 3650);
		Mockito.doNothing().when(weatherRepository).deleteAll();
		Integer precision = 1;
		Integer destroy = 1;
		Boolean destroyOk = galaxyManager.initializeGalaxy(precision, destroy);
		assertEquals(Boolean.TRUE, destroyOk);
		Mockito.verify(weatherRepository).count();
		Mockito.verify(weatherRepository).deleteAll();
		
		
	}
	
	

}
