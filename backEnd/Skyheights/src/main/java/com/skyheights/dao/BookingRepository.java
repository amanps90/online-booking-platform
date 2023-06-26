package com.skyheights.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skyheights.model.Booking;
import com.skyheights.model.User;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	List<Booking> findByUser(User id);
	
}
