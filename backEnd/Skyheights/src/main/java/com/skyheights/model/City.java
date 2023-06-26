package com.skyheights.model;

import javax.persistence.*;

@Entity
@Table(name="city_table")
public class City {
	@Id
	@GeneratedValue
	private int cityId;
	private String cityName;
	
	//default constructor 
	public City() {
		
	}
	
	//setters and getters 
	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public City(int cityId, String cityName) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + "]";
	}
	
	
	
	
}
