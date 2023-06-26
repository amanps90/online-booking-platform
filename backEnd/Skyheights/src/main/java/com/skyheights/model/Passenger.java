package com.skyheights.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "passenger_details")
public class Passenger {
	@Id
	@GeneratedValue
	private int passengerId;
	private String passengerName;
	private String gender;
	private String citizenType;
	private int age;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "booking_id")
	private Booking booking;
	@OneToOne
	@JoinColumn(name = "seat_id")
	private Seat seat;

	public Passenger() {
		// TODO Auto-generated constructor stub
	}

	public Passenger(int passengerId, String passengerName, String gender, String citizenType, int age,
			Booking bookingId, Seat seatId) {
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.gender = gender;
		this.citizenType = citizenType;
		this.age = age;
		this.booking = bookingId;
		this.seat = seatId;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCitizenType() {
		return citizenType;
	}

	public void setCitizenType(String citizenType) {
		this.citizenType = citizenType;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

}
