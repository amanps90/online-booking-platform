package com.skyheights.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;

@Entity
@Table(name="schedule_table")
public class Schedule {
	@Id
	@GeneratedValue
	private int scheduleId;
	@ManyToOne
	@JoinColumn(name="flight_id")
	private Flight flight;
	@OneToOne
	@JoinColumn(name="from_city")
	private City fromCity;
	@OneToOne
	@JoinColumn(name="to_city")
	private City toCity;
	private Time depatureTime;
	private Time arrivalTime;
	private Date depatureDate;
	private Date arrivalDate;
	
	//default constructor 
	public Schedule() {
		// TODO Auto-generated constructor stub
	}
	
	//setters and getters
	
	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public City getFromCity() {
		return fromCity;
	}

	public void setFromCity(City fromCity) {
		this.fromCity = fromCity;
	}

	public City getToCity() {
		return toCity;
	}

	public void setToCity(City toCity) {
		this.toCity = toCity;
	}

	public Time getDepatureTime() {
		return depatureTime;
	}

	public void setDepatureTime(Time depatureTime) {
		this.depatureTime = depatureTime;
	}

	public Time getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Time arrivalTime) {
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

	public Schedule(int scheduleId, Flight flight, City fromCity, City toCity, Time depatureTime, Time arrivalTime,
			Date depatureDate, Date arrivalDate) {
		super();
		this.scheduleId = scheduleId;
		this.flight = flight;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.depatureTime = depatureTime;
		this.arrivalTime = arrivalTime;
		this.depatureDate = depatureDate;
		this.arrivalDate = arrivalDate;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", flight=" + flight + ", fromCity=" + fromCity + ", toCity="
				+ toCity + ", depatureTime=" + depatureTime + ", arrivalTime=" + arrivalTime + ", depatureDate="
				+ depatureDate + ", arrivalDate=" + arrivalDate + "]";
	}
	
	
	
	
	
}
