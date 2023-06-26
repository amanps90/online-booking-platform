package com.skyheights.dto;

import com.skyheights.model.Booking;
import com.skyheights.model.User;

public class PostComplaintDTO {
	private String complaintDescription;
	private Booking booking;
	private User user;
	
	public PostComplaintDTO() {
	}

	public String getComplaintDescription() {
		return complaintDescription;
	}

	public void setComplaintDescription(String complaintDescription) {
		this.complaintDescription = complaintDescription;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PostComplaintDTO(String complaintDescription, Booking booking, User user) {
		this.complaintDescription = complaintDescription;
		this.booking = booking;
		this.user = user;
	}

	@Override
	public String toString() {
		return "PostComplaintDTO [complaintDescription=" + complaintDescription + ", booking=" + booking + ", user="
				+ user + "]";
	}

	
	
}
