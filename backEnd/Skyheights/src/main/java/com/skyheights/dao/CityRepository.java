package com.skyheights.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skyheights.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{
	
	City findByCityName(String cityName);

}
