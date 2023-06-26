package com.skyheights.dto;

import java.sql.Date;

public class SearchDto {
	private String fromCity;
	private String toCity;
	private Date doj;
	
	public SearchDto() {
		
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public SearchDto(String fromCity, String toCity, Date doj) {
		super();
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "SearchDto [fromCity=" + fromCity + ", toCity=" + toCity + ", doj=" + doj + "]";
	}
	
	
}
