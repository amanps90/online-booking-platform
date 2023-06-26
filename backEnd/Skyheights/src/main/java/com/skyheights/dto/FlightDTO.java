package com.skyheights.dto;

public class FlightDTO {
	
	private String company;
	private String flightNumber;
	private int noOfStops;
	private String stopName;
	
public FlightDTO() {
	// TODO Auto-generated constructor stub
}

public FlightDTO(String company, String flightNumber, int noOfStops, String stopName) {
	super();
	this.company = company;
	this.flightNumber = flightNumber;
	this.noOfStops = noOfStops;
	this.stopName = stopName;
}

public String getCompany() {
	return company;
}

public void setCompany(String company) {
	this.company = company;
}

public String getFlightNumber() {
	return flightNumber;
}

public void setFlightNumber(String flightNumber) {
	this.flightNumber = flightNumber;
}

public int getNoOfStops() {
	return noOfStops;
}

public void setNoOfStops(int noOfStops) {
	this.noOfStops = noOfStops;
}

public String getStopName() {
	return stopName;
}

public void setStopName(String stopName) {
	this.stopName = stopName;
}

@Override
public String toString() {
	return "FlightDTO [company=" + company + ", flightNumber=" + flightNumber + ", noOfStops=" + noOfStops
			+ ", stopName=" + stopName + "]";
}



}
