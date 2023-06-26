package com.skyheights.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skyheights.dao.CompanyRepository;

import com.skyheights.dao.FlightRepository;

import com.skyheights.dto.FlightDTO;
import com.skyheights.dto.PriceDTO;
import com.skyheights.model.Company;
import com.skyheights.model.Flight;


@Service
public class FlightService {
	@Autowired
	FlightRepository flightDao;
	@Autowired
	CompanyRepository companyDao;


	public void addFlight(FlightDTO flightDto) {
		Company currentCompany = companyDao.findByCompanyName(flightDto.getCompany()); // repo
																						// findByCompanyName(dto.getCompanyName)
		Flight flight = new Flight();
		flight.setActive(true);
		flight.setFlightNumber(flightDto.getFlightNumber());
		flight.setCompany(currentCompany);
		flightDao.save(flight);
	}

	public List<Company> getAllCompany() {
		System.out.println("in service");
		return companyDao.findAll();
	}

	public void deleteFlight(int flightId) {
		flightDao.deleteById(flightId);
	}

	public List<Flight> getAllFlights() {
		return flightDao.findAll();
	}

	public void updateFlight(int flightId, FlightDTO updatedFlight) {
		Company currentCompany = companyDao.findByCompanyName(updatedFlight.getCompany());
		// Flight flight=new Flight();
		/*
		 * updatedFlight=flightDtoRepo.findById(flightId).get(); flight.setActive(true);
		 * flight.setFlightNumber(updatedFlight.getFlightNumber());
		 * flight.setCompany(currentCompany);
		 */
		Flight flight = flightDao.findById(flightId).get();
		flight.setCompany(currentCompany);
		flight.setFlightNumber(updatedFlight.getFlightNumber());
		flight.setActive(true);
		flightDao.save(flight);
	}

	public void addPrice(PriceDTO newPrice) {
		Flight flight=flightDao.findById(newPrice.getFlight().getFlightId()).get();
		flight.setEconomyPrice(newPrice.getEconomyPrice());
		flight.setBusinessPrice(newPrice.getBusinessPrice());
		flight.setPremiumPrice(newPrice.getPremiumPrice());
		flightDao.save(flight);
	}

	public Flight getFlightById(int flightId) {
		
		return flightDao.findById(flightId).get();
	}

	

	
}
