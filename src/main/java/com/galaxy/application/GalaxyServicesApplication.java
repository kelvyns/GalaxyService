package com.galaxy.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kelvyns
 *
 */
@Configuration
@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration
public class GalaxyServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(GalaxyServicesApplication.class, args);
    }
}
