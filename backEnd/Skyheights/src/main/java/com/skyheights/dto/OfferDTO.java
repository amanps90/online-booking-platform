package com.skyheights.dto;

public class OfferDTO {
	
	private String company;
	private int discount;
	
	public OfferDTO() {
		// TODO Auto-generated constructor stub
	}

	public OfferDTO(String company, int discount) {
		super();
		this.company = company;
		this.discount = discount;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "OfferDTO [company=" + company + ", discount=" + discount + "]";
	}
	
	
}
