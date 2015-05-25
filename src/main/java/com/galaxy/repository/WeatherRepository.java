package com.galaxy.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.galaxy.data.WeatherTypeEnum;
import com.galaxy.entity.Weather;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, Long> {
	Weather findByDay (Integer day);
	Collection<Weather> findByWeatherType ( WeatherTypeEnum weatherType);
}
