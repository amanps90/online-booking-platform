package com.skyheights.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "feedback_table")
public class Feedback {
	@Id
	@GeneratedValue
 private int feedbackId;
	
 @ManyToOne
 @JoinColumn(name="user_id")
 private User user;
 @ManyToOne
 @JoinColumn(name="company_id")
 private Company company;
 
 @OneToOne
 @JoinColumn(name="booking")
 private Booking booking;
 
 private int food;
 private int sanitization;
 private int hospitality;
 private int timing;
 
 
 
public Feedback() {
}

public Feedback(int feedbackId, User user, Company company, Booking booking, int food, int sanitization,
		int hospitality, int timing) {
	this.feedbackId = feedbackId;
	this.user = user;
	this.company = company;
	this.booking = booking;
	this.food = food;
	this.sanitization = sanitization;
	this.hospitality = hospitality;
	this.timing = timing;
}
public int getFeedbackId() {
	return feedbackId;
}
public void setFeedbackId(int feedbackId) {
	this.feedbackId = feedbackId;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Company getCompany() {
	return company;
}
public void setCompany(Company company) {
	this.company = company;
}
public Booking getBooking() {
	return booking;
}
public void setBooking(Booking booking) {
	this.booking = booking;
}
public int getFood() {
	return food;
}
public void setFood(int food) {
	this.food = food;
}
public int getSanitization() {
	return sanitization;
}
public void setSanitization(int sanitization) {
	this.sanitization = sanitization;
}
public int getHospitality() {
	return hospitality;
}
public void setHospitality(int hospitality) {
	this.hospitality = hospitality;
}
public int getTiming() {
	return timing;
}
public void setTiming(int timing) {
	this.timing = timing;
}
@Override
public String toString() {
	return "Feedback [feedbackId=" + feedbackId + ", user=" + user + ", company=" + company + ", booking=" + booking
			+ ", food=" + food + ", sanitization=" + sanitization + ", hospitality=" + hospitality + ", timing="
			+ timing + "]";
}
 
 
 
 
}

