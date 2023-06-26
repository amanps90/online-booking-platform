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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skyheights.dto.FlightDTO;
import com.skyheights.dto.OfferDTO;
import com.skyheights.dto.PriceDTO;
import com.skyheights.dto.ScheduleDTO;
import com.skyheights.dto.SearchDto;
import com.skyheights.model.City;
import com.skyheights.model.Company;
//import com.skyheights.dto.SearchDto;
import com.skyheights.model.Flight;
import com.skyheights.model.MessageResponse;
import com.skyheights.model.Offer;
import com.skyheights.model.Schedule;
import com.skyheights.model.User;
import com.skyheights.service.FlightService;
import com.skyheights.service.OfferService;
import com.skyheights.service.ScheduleService;
import com.skyheights.service.UserService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class AdminController {
	@Autowired
	FlightService flightService;
	@Autowired
	ScheduleService scheduleService;
	@Autowired
	OfferService offerService;
	@Autowired 
	UserService userService;

	// FLIGHT CRUD OPERATIONS
	@GetMapping("/showAllFlights")
	public ResponseEntity<List<Flight>> getAllFlights() {
		List<Flight> allFlights = flightService.getAllFlights();
		return new ResponseEntity<List<Flight>>(allFlights, HttpStatus.OK);
	}

	@PostMapping("/addFlight")
	public ResponseEntity<MessageResponse> addNewFlight(@RequestBody FlightDTO newFlight) {
		System.out.println("in methiod");
		System.out.println(newFlight);
		flightService.addFlight(newFlight);
		return new ResponseEntity<MessageResponse>(new MessageResponse("flight added successfully"), HttpStatus.OK);
	}

	@DeleteMapping("/removeFlight/{id}")
	public ResponseEntity<MessageResponse> removeFlight(@PathVariable int id) {
		flightService.deleteFlight(id);
		return new ResponseEntity<MessageResponse>(new MessageResponse("flight has been removed"), HttpStatus.OK);
	}

	@PutMapping("/updateFlight/{id}")
	public ResponseEntity<MessageResponse> updateFlight(@PathVariable int id, @RequestBody FlightDTO flight) {
		flightService.updateFlight(id, flight);
		return new ResponseEntity<MessageResponse>(new MessageResponse("flight details updated"), HttpStatus.OK);
	}

	@GetMapping("/getAllCompany")
	public ResponseEntity<List<Company>> getAllCompany() {
		List<Company> allCompany = flightService.getAllCompany();
		return new ResponseEntity<List<Company>>(allCompany, HttpStatus.OK);
	}

	// SCHEDULE CRUD OPERATIONS

	@GetMapping("/showAllSchedule")
	public ResponseEntity<List<Schedule>> getAllSchedule() {
		List<Schedule> allSchedule = scheduleService.getAllSchedule();
		allSchedule.forEach(System.out::println);
		return new ResponseEntity<List<Schedule>>(allSchedule, HttpStatus.OK);
	}

	@PostMapping("/flightSchedule")
	public ResponseEntity<List<Schedule>> getAllScheduleByFlight(@RequestBody Flight flight) {
		System.out.println(flight);
		List<Schedule> allSchedule = scheduleService.getScheduleByFlight(flight);
		allSchedule.forEach(System.out::println);
		return new ResponseEntity<List<Schedule>>(allSchedule, HttpStatus.OK);
	}

	@PostMapping("/addSchedule")
	public ResponseEntity<MessageResponse> addNewSchedule(@RequestBody ScheduleDTO newSchedule) {
		scheduleService.addSchedule(newSchedule);
		return new ResponseEntity<MessageResponse>(new MessageResponse("schedule added successfully"), HttpStatus.OK);
	}

	@DeleteMapping("/removeSchedule/{id}")
	public ResponseEntity<MessageResponse> removeSchedule(@PathVariable int id) {
		scheduleService.deleteScheudle(id);
		return new ResponseEntity<MessageResponse>(new MessageResponse("schedule has been removed"), HttpStatus.OK);
	}

	@PutMapping("/updateSchedule/{id}")
	public ResponseEntity<MessageResponse> updateSchedule(@PathVariable int id, @RequestBody ScheduleDTO schedule) {
		scheduleService.updateSchedule(id, schedule);
		return new ResponseEntity<MessageResponse>(new MessageResponse("schedule details updated"), HttpStatus.OK);
	}

	@GetMapping("/getAllCity")
	public ResponseEntity<List<City>> getAllCity() {
		List<City> allCity = scheduleService.getAllCity();
		return new ResponseEntity<List<City>>(allCity, HttpStatus.OK);
	}

	@PostMapping("/addPrice")
	public ResponseEntity<MessageResponse> addPrice(@RequestBody PriceDTO newPrice) {
		flightService.addPrice(newPrice);
		return new ResponseEntity<MessageResponse>(new MessageResponse("price added successfully"), HttpStatus.OK);

	}

	@GetMapping("/getCurrentFlight/{flightId}")
	public ResponseEntity<Flight> getFlightById(@PathVariable int flightId) {
		return new ResponseEntity<Flight>(flightService.getFlightById(flightId), HttpStatus.OK);
	}

	// OFFER CRUD OPERATION
	@GetMapping("/showAllOffers")
	public ResponseEntity<List<Offer>> getAllOffers() {
		List<Offer> allOffers = offerService.getAllOffers();
		return new ResponseEntity<List<Offer>>(allOffers, HttpStatus.OK);
	}

	@PostMapping("/addOffer")
	public ResponseEntity<MessageResponse> addNewOffer(@RequestBody OfferDTO offer) {
		System.out.println("in method");
		System.out.println(offer);
		offerService.addOffer(offer);
		return new ResponseEntity<MessageResponse>(new MessageResponse("Offer added successfully"), HttpStatus.OK);
	}

	@PutMapping("/updateOffer/{id}")
	public ResponseEntity<MessageResponse> updateOffer(@PathVariable int id, @RequestBody OfferDTO offer) {
		offerService.updateOffer(id, offer);
		return new ResponseEntity<MessageResponse>(new MessageResponse("Offer details updated"), HttpStatus.OK);
	}

	@DeleteMapping("/removeOffer/{id}")
	public ResponseEntity<MessageResponse> removeOffer(@PathVariable int id) {
		offerService.deleteOffer(id);
		return new ResponseEntity<MessageResponse>(new MessageResponse("Offer has been removed"), HttpStatus.OK);
	}

	@PostMapping("/showAllSearchResult")
	public ResponseEntity<List<Schedule>> searchResult(@RequestBody SearchDto searchDto) {
		System.out.println("inside search method");
		List<Schedule> allSchedule = scheduleService.getSearchResult(searchDto);
		System.out.println(allSchedule);
		return new ResponseEntity<List<Schedule>>(allSchedule, HttpStatus.OK);
	}
	
	//User block unblock methods
	
	@PostMapping("/blockUser")
	public ResponseEntity<MessageResponse> blockUser(@RequestBody User user){
		userService.blockUserAccount(user);
		return new ResponseEntity<MessageResponse>(new MessageResponse("user has been blocked"),HttpStatus.OK);
	}
	
	@PostMapping("/unblockUser")
	public ResponseEntity<MessageResponse> unblockUser(@RequestBody User user){
		userService.unblockUserAccount(user);
		return new ResponseEntity<MessageResponse>(new MessageResponse("user has been unblocked"),HttpStatus.OK);
	}
	
	//get all blocked users
	@GetMapping("/getAllBlockUsers")
	public ResponseEntity<List<User>> allBlockedUsers(){
		List<User> blockUsers = userService.getAllBlockUsers();
		return new ResponseEntity<List<User>>(blockUsers,HttpStatus.OK);
	}
	
	//testting git push here on login ui branch 
}
