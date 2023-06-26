package com.skyheights.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="complaint_table")
public class Complaint {
	@Id
	@GeneratedValue
	 private int complaintId;
	 private Date dateOfComplaintRegister;
	 private Date dateOfComplaintResolved;
	 private String complaintDescription;
	 private String adminComplaintReply;
	 private boolean complaintStatus;
	 private boolean isActive;
	 
	 @ManyToOne
	 @JoinColumn(name="user_id")
	 private User user;
	 
	 @OneToOne
	 @JoinColumn(name="booking_id")
	 private Booking booking;
	 
	public Complaint() {
	}

	public Complaint(int complaintId, Date dateOfComplaintRegister, Date dateOfComplaintResolved,
			String complaintDescription, String adminComplaintReply, boolean complaintStatus, boolean isActive,
			User user, Booking booking) {
		this.complaintId = complaintId;
		this.dateOfComplaintRegister = dateOfComplaintRegister;
		this.dateOfComplaintResolved = dateOfComplaintResolved;
		this.complaintDescription = complaintDescription;
		this.adminComplaintReply = adminComplaintReply;
		this.complaintStatus = complaintStatus;
		this.isActive = isActive;
		this.user = user;
		this.booking = booking;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public Date getDateOfComplaintRegister() {
		return dateOfComplaintRegister;
	}

	public void setDateOfComplaintRegister(Date dateOfComplaintRegister) {
		this.dateOfComplaintRegister = dateOfComplaintRegister;
	}

	public Date getDateOfComplaintResolved() {
		return dateOfComplaintResolved;
	}

	public void setDateOfComplaintResolved(Date dateOfComplaintResolved) {
		this.dateOfComplaintResolved = dateOfComplaintResolved;
	}

	public String getComplaintDescription() {
		return complaintDescription;
	}

	public void setComplaintDescription(String complaintDescription) {
		this.complaintDescription = complaintDescription;
	}

	public String getAdminComplaintReply() {
		return adminComplaintReply;
	}

	public void setAdminComplaintReply(String adminComplaintReply) {
		this.adminComplaintReply = adminComplaintReply;
	}

	public boolean isComplaintStatus() {
		return complaintStatus;
	}

	public void setComplaintStatus(boolean complaintStatus) {
		this.complaintStatus = complaintStatus;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId + ", dateOfComplaintRegister=" + dateOfComplaintRegister
				+ ", dateOfComplaintResolved=" + dateOfComplaintResolved + ", complaintDescription="
				+ complaintDescription + ", adminComplaintReply=" + adminComplaintReply + ", complaintStatus="
				+ complaintStatus + ", isActive=" + isActive + ", user=" + user + ", booking=" + booking + "]";
	}
	
	
	
	

	

	
	
	 
	 
	 
}