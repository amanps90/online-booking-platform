package com.skyheights.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skyheights.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>{
	
	

}
