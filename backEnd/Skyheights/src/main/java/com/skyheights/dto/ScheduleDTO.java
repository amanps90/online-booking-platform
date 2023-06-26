package com.skyheights.dto;

import java.sql.Date;
import java.sql.Time;

import com.skyheights.model.Flight;

public class ScheduleDTO {

	private int scheduleId;

	private String fromCity;
	private Flight flight;
	private String toCity;
	private Date depatureDate;
	private Date arrivalDate;
	private String depatureTime;
	private String arrivalTime;

	public ScheduleDTO() {
		// TODO Auto-generated constructor stub
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
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

	public String getDepatureTime() {
		return depatureTime;
	}

	public void setDepatureTime(String depatureTime) {
		this.depatureTime = depatureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Date getDepatureDate() {
		return depatureDate;
	}

	public void setDepatureDate(Date depatureDate) {
		this.depatureDate = depatureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public ScheduleDTO(int scheduleId, String fromCity, String toCity, String depatureTime, String arrivalTime,
			Date depatureDate, Date arrivalDate) {
		super();
		this.scheduleId = scheduleId;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.depatureTime = depatureTime;
		this.arrivalTime = arrivalTime;
		this.depatureDate = depatureDate;
		this.arrivalDate = arrivalDate;
	}

	@Override
	public String toString() {
		return "ScheduleDTO [scheduleId=" + scheduleId + ", fromCity=" + fromCity + ", toCity=" + toCity
				+ ", depatureTime=" + depatureTime + ", arrivalTime=" + arrivalTime + ", depatureDate=" + depatureDate
				+ ", arrivalDate=" + arrivalDate + "]";
	}

}
