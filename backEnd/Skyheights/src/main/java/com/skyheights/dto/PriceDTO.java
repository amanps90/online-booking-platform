package com.skyheights.dto;

import com.skyheights.model.Flight;

public class PriceDTO {
	private int economyPrice;
	private int businessPrice;
	private int premiumPrice;
	private Flight flight;
	
	public PriceDTO() {
		// TODO Auto-generated constructor stub
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

	

	public PriceDTO(int economyPrice, int businessPrice, int premiumPrice, Flight flight) {
		super();
		this.economyPrice = economyPrice;
		this.businessPrice = businessPrice;
		this.premiumPrice = premiumPrice;
		this.flight = flight;
	}


	@Override
	public String toString() {
		return "PriceDTO [economyPrice=" + economyPrice + ", businessPrice=" + businessPrice + ", premiumPrice="
				+ premiumPrice + ", flight=" + flight + "]";
	}


	
	
}
