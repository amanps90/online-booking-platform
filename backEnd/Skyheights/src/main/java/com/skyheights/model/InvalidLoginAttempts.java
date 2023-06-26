package com.skyheights.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="invalid_login_table")
public class InvalidLoginAttempts {
	@Id
	@GeneratedValue
	private int attemptId;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	private Date attemptLog;
	
	//default constructor 
	public InvalidLoginAttempts() {
		
	}

	public int getAttemptId() {
		return attemptId;
	}

	public void setAttemptId(int attemptId) {
		this.attemptId = attemptId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getAttemptLog() {
		return attemptLog;
	}

	public void setAttemptLog(Date attemptLog) {
		this.attemptLog = attemptLog;
	}

	public InvalidLoginAttempts(int attemptId, User user, Date attemptLog) {
		super();
		this.attemptId = attemptId;
		this.user = user;
		this.attemptLog = attemptLog;
	}

	@Override
	public String toString() {
		return "InvalidLoginAttempts [attemptId=" + attemptId + ", user=" + user + ", attemptLog=" + attemptLog + "]";
	}
	
	
}
