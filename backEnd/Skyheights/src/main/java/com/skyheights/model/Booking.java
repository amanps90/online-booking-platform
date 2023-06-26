package com.skyheights.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="booking_table")
public class Booking {
	@Id
	@GeneratedValue
	private int bookingId;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;
	@ManyToOne
	@JoinColumn(name = "offer_id")
	private Offer offer;
	private int finalAmount;
	private boolean isConfirm;
	private String ticketNumber;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
	private List<Passenger> passengerList;

	public Booking() {

	}

	public Booking(int bookingId, User user, Schedule schedule, Offer offer, int finalAmount, boolean isConfirm,
			String ticketNumber) {
		super();
		this.bookingId = bookingId;
		this.user = user;
		this.schedule = schedule;
		this.offer = offer;
		this.finalAmount = finalAmount;
		this.isConfirm = isConfirm;
		this.ticketNumber = ticketNumber;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public int getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(int finalAmount) {
		this.finalAmount = finalAmount;
	}

	public boolean isConfirm() {
		return isConfirm;
	}

	public void setConfirm(boolean isConfirm) {
		this.isConfirm = isConfirm;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
		for (Passenger p : passengerList) {
			p.setBooking(this);
		}
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", user=" + user + ", schedule=" + schedule + ", offer=" + offer
				+ ", finalAmount=" + finalAmount + ", isConfirm=" + isConfirm + ", ticketNumber=" + ticketNumber
				+ ", passengerList=" + passengerList + "]";
	}


}
