package com.skyheights.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skyheights.model.Booking;
import com.skyheights.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

	List<Passenger> findByBooking(Booking booking);

}
