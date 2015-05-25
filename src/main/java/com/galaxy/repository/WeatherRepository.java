package com.galaxy.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.galaxy.entity.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
	Collection<Weather> findByDay (Integer day);
}
