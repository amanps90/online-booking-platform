package com.skyheights.model;

import javax.persistence.*;

@Entity
@Table(name="price_table")
public class Price {
	@Id
	@GeneratedValue
	private int priceId;
	@OneToOne
	@JoinColumn(name="flight_id")
	private Flight flight;
	private int economyPrice;
	private int businessPrice;
	private int premiumPrice;
	
	//defalut constructor
	public Price() {
		
	}

	public int getPriceId() {
		return priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
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

	public Price(int priceId, Flight flight, int economyPrice, int businessPrice, int premiumPrice) {
		super();
		this.priceId = priceId;
		this.flight = flight;
		this.economyPrice = economyPrice;
		this.businessPrice = businessPrice;
		this.premiumPrice = premiumPrice;
	}

	@Override
	public String toString() {
		return "Price [priceId=" + priceId + ", flight=" + flight + ", economyPrice=" + economyPrice
				+ ", businessPrice=" + businessPrice + ", premiumPrice=" + premiumPrice + "]";
	}
	
	
}
