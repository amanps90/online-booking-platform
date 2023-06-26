package com.skyheights.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyheights.dao.BookingRepository;
import com.skyheights.dao.OfferRepository;
import com.skyheights.dto.BookingDTO;
import com.skyheights.model.Booking;
import com.skyheights.model.Company;
import com.skyheights.model.Offer;
import com.skyheights.model.User;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	OfferRepository offerRepository;
	
	@Autowired
	EmailService emailService;

	public void addBooking(BookingDTO booking) {
		Booking newBooking = booking.getBooking();
		newBooking.setPassengerList(booking.getPassengerList());
		System.out.println(newBooking);
		User currentUser = newBooking.getUser();
		bookingRepository.save(newBooking);
		
	}

	public List<Booking> showAll() {
		return bookingRepository.findAll();
	}

	public List<Booking> showAllBookingByUser(User user) {
		// TODO Auto-generated method stub
		return bookingRepository.findByUser(user);
	}

	public List<Offer> showOfferByCompany(Company company) {
		return offerRepository.findByCompany(company);
	}

}
