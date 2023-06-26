package com.skyheights.model;

import javax.persistence.*;

@Entity
@Table(name = "flight_table")
public class Flight {
	@Id
	@GeneratedValue
	private int flightId;
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	private String flightNumber;
	private int economyPrice;
	private int businessPrice;
	private int premiumPrice;
	private boolean isActive;
	
	//default constructor
	public Flight() {
		
	}
	//setters and getters
	
	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	

	public int getEconomyPrice() {
		return economyPrice;
	}

	public void setEconomyPrice(int economyPrice) {
		this.economyPrice = economyPrice;
	}

	public int getBusinessPrice() {
		return businessPrice;
	}

	public void setBusinessPrice(int businessPrice) {
		this.businessPrice = businessPrice;
	}

	public int getPremiumPrice() {
		return premiumPrice;
	}

	public void setPremiumPrice(int premiumPrice) {
		this.premiumPrice = premiumPrice;
	}

	

	public Flight(int flightId, Company company, String flightNumber, int economyPrice, int businessPrice,
			int premiumPrice, boolean isActive) {
		super();
		this.flightId = flightId;
		this.company = company;
		this.flightNumber = flightNumber;
		this.economyPrice = economyPrice;
		this.businessPrice = businessPrice;
		this.premiumPrice = premiumPrice;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", company=" + company + ", flightNumber=" + flightNumber
				+ ", economyPrice=" + economyPrice + ", businessPrice=" + businessPrice + ", premiumPrice="
				+ premiumPrice + ", isActive=" + isActive + "]";
	}
	
	
}
