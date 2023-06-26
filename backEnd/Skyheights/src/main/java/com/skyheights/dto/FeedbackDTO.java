package com.skyheights.dto;

import org.springframework.beans.BeanUtils;

import com.skyheights.model.Booking;
import com.skyheights.model.Company;
import com.skyheights.model.Feedback;
import com.skyheights.model.User;

public class FeedbackDTO {
	private User user;
	private Company company;
	private Booking booking;
	private int food;
	private int sanitization;
	private int hospitality;
	private int timing;
	
	public FeedbackDTO() {
		// TODO Auto-generated constructor stub
	}

	
	
	


	public FeedbackDTO(User user, Company company, Booking booking, int food, int sanitization, int hospitality,
			int timing) {
		this.user = user;
		this.company = company;
		this.booking = booking;
		this.food = food;
		this.sanitization = sanitization;
		this.hospitality = hospitality;
		this.timing = timing;
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
		return "FeedbackDTO [user=" + user + ", company=" + company + ", booking=" + booking + ", food=" + food
				+ ", sanitization=" + sanitization + ", hospitality=" + hospitality + ", timing=" + timing + "]";
	}






	public static FeedbackDTO fromEntity(Feedback feedback) {
		FeedbackDTO dto = new FeedbackDTO();
		BeanUtils.copyProperties(feedback, dto);
//		dto.setCompanyId(feedback.getCompany().getCompanyId());
//		dto.setCompanyName(feedback.getCompany().getCompanyName());
//		dto.setUserId(feedback.getUser().getUserId());
//		dto.setUserName(feedback.getUser().getUserName());
		return dto;
	}
}
