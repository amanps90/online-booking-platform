package com.skyheights.model;

import javax.persistence.*;

@Entity
@Table(name="offer_table")
public class Offer {
	@Id
	@GeneratedValue
	private int offerId;
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	@OneToOne
	@JoinColumn(name="schedule_id")
	private Schedule schedule;
	private int discount;
	
	//default constructor
	public Offer() {
		// TODO Auto-generated constructor stub
	}
	
	//setters and getters
	
	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	//to string for debug
	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", company=" + company + ", schedule=" + schedule + ", discount="
				+ discount + "]";
	}
	//parameterized constructor  
	public Offer(int offerId, Company company, Schedule schedule, int discount) {
		super();
		this.offerId = offerId;
		this.company = company;
		this.schedule = schedule;
		this.discount = discount;
	}
	
	
}
