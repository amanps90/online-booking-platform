package com.skyheights.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skyheights.model.Booking;
import com.skyheights.model.Passenger;
import com.skyheights.service.PassengerService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class PassengerController {

	@Autowired
	PassengerService passengerService;

	@PostMapping("/addPassenger")
	public ResponseEntity<String> addPassenger(@RequestBody Passenger newPassenger) {
		passengerService.addPassenger(newPassenger);

		return new ResponseEntity<String>("Passenger Added Successfully", HttpStatus.CREATED);
	}

	@GetMapping("/showAllPassenger")
	public ResponseEntity<List<Passenger>> getAllPassengers() {
		return new ResponseEntity<List<Passenger>>(passengerService.showAll(), HttpStatus.OK);
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<String> deletePassenger(@PathVariable int id) {
		passengerService.deletePassengerById(id);
		return new ResponseEntity<String>("Passenger deleted", HttpStatus.OK);
	}

	@PostMapping("/getPassengerByTickets")
	public ResponseEntity<List<Passenger>> getPassengerByTickets(@RequestBody Booking booking) {
		List<Passenger> passengers = passengerService.getPassengerByTickets(booking);
		return new ResponseEntity<List<Passenger>>(passengers, HttpStatus.OK);
	}

}
