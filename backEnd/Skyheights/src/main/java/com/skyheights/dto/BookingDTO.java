package com.skyheights.dto;

import java.util.List;

import com.skyheights.model.Booking;
import com.skyheights.model.Passenger;
public class BookingDTO {

	private Booking booking;

	List<Passenger> passengerList;
	
	public BookingDTO() {
		// TODO Auto-generated constructor stub
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	@Override
	public String toString() {
		return "BookingDTO [booking=" + booking + ", passengerList=" + passengerList + "]";
	}
	
	
	

}
