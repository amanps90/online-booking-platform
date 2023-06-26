package com.skyheights.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skyheights.model.City;
import com.skyheights.model.Flight;
import com.skyheights.model.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{
	
	List<Schedule>findByFlight(Flight flight);
	List<Schedule>findByFromCityAndToCityAndDepatureDate(City fromCity,City toCity,Date depatureDate);
}
