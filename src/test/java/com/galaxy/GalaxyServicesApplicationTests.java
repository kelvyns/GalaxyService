package com.galaxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.galaxy.GalaxyServicesApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GalaxyServicesApplication.class)
@WebAppConfiguration
public class GalaxyServicesApplicationTests {

	@Test
	public void contextLoads() {
	}

}
