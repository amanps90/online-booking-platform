package com.skyheights.model;

import javax.persistence.*;

@Entity
@Table(name="seat_table")
public class Seat {
	@Id
	@GeneratedValue
	private int seatId;
	private String seatCode;
	private String seatType;
	
	//default constructor
	public Seat() {
		
	}
	
	//setters and getters
	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public String getSeatCode() {
		return seatCode;
	}

	public void setSeatCode(String seatCode) {
		this.seatCode = seatCode;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public Seat(int seatId, String seatCode, String seatType) {
		super();
		this.seatId = seatId;
		this.seatCode = seatCode;
		this.seatType = seatType;
	}

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatCode=" + seatCode + ", seatType=" + seatType + "]";
	}
	
	
}
