package com.skyheights.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skyheights.dao.PassengerRepository;
import com.skyheights.model.Booking;
import com.skyheights.model.Passenger;

@Service
public class PassengerService {

	@Autowired
	PassengerRepository passengerRepository;

	public void addPassenger(Passenger passenger) {
		passengerRepository.save(passenger);
	}

	public List<Passenger> showAll() {
		return passengerRepository.findAll();
	}

	public void deletePassengerById(int id) {
		passengerRepository.deleteById(id);

	}

	public List<Passenger> getPassengerByTickets(Booking booking) {
		return passengerRepository.findByBooking(booking);
	}

}
