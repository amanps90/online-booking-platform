package com.skyheights.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skyheights.model.Booking;
import com.skyheights.model.Company;
import com.skyheights.model.MessageResponse;
import com.skyheights.model.Offer;
import com.skyheights.model.User;
import com.skyheights.service.BookingService;
import com.skyheights.dto.BookingDTO;

@RestController
@CrossOrigin("http://localhost:4200/")
public class BookingController {

	@Autowired
	BookingService bookingService;

	private static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);

	@PostMapping("/addBooking")
	public ResponseEntity<MessageResponse> addBooking(@RequestBody BookingDTO newbooking) {
		System.out.println(newbooking);

		bookingService.addBooking(newbooking);

		return new ResponseEntity<MessageResponse>(new MessageResponse("Booking Done Successfully..!"), HttpStatus.OK);
	}

	@GetMapping("/showAllBooking")
	public ResponseEntity<List<Booking>> getAllBooking() {
		return new ResponseEntity<List<Booking>>(bookingService.showAll(), HttpStatus.OK);
	}

	@GetMapping("/showAllBookingByUser/{user}")
	public ResponseEntity<List<Booking>> getAllBookingByUser(@PathVariable User user) {
		LOGGER.info("Booking");
		return new ResponseEntity<List<Booking>>(bookingService.showAllBookingByUser(user), HttpStatus.OK);

	}

	@PostMapping("/getOffer")
	public ResponseEntity<List<Offer>> getOfferByCompany(@RequestBody Company company) {
		return new ResponseEntity<List<Offer>>(bookingService.showOfferByCompany(company), HttpStatus.OK);
	}

}
