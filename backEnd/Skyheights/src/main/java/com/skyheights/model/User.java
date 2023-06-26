package com.skyheights.model;

import java.sql.Date;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.loader.plan.build.spi.QuerySpaceTreePrinter;

@Entity
@Table(name = "user_table", uniqueConstraints = { @UniqueConstraint(columnNames = { "user_email" }),
		@UniqueConstraint(columnNames = { "user_contact" }) })
public class User {
	private static final long OTP_VALID_DURATION =  5*60* 1000; // 5 minutes

	@Id
	@GeneratedValue
	private int userId;
	private String userName;
	private String userPassword;
	@Column(name = "user_email")
	private String userEmail;
	@Column(name = "user_contact")
	private String userContact;
	private String gender;
	private boolean isAdmin;
	private boolean isActive;
	private Date accountCreationDate;
	private boolean isBlocked;
	@Column(name = "one_time_password")
	private String oneTimePassword;

	@Column(name = "otp_requested_time")
	private String otpRequestedTime; //in miliseconds

	private String roles;
	@Column(name="verification_code")
	private String verificationCode;

	// default constructors
	public User() {

	}

	/**
	 * @author amansing 
	 *  method to check if OTP is expired or not
	 * @return boolean
	 */
	public boolean isOTPExpired() {
		// no otp
		if (this.getOneTimePassword() == null) {
			return true;
		}

		long currentTimeInMillis = System.currentTimeMillis();
		long otpRequestedTimeInMillis = Long.parseLong(this.otpRequestedTime);
		System.out.println(otpRequestedTimeInMillis+OTP_VALID_DURATION +" validity");
		System.out.println(currentTimeInMillis +"current time ");

		if (otpRequestedTimeInMillis + OTP_VALID_DURATION < currentTimeInMillis) {
			// OTP expires
			System.out.println("inside < eq");
			return true;
		}

		return false;
	}

	// setters and getters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getAccountCreationDate() {
		return accountCreationDate;
	}

	public void setAccountCreationDate(Date accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public String getOneTimePassword() {
		return oneTimePassword;
	}

	public void setOneTimePassword(String oneTimePassword) {
		this.oneTimePassword = oneTimePassword;
	}

	public String getOtpRequestedTime() {
		return otpRequestedTime;
	}

	public void setOtpRequestedTime(String otpRequestedTime) {
		this.otpRequestedTime = otpRequestedTime;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public User(int userId, String userName, String userPassword, String userEmail, String userContact, String gender,
			boolean isAdmin, boolean isActive, Date accountCreationDate, boolean isBlocked, String oneTimePassword,
			String otpRequestedTime, String roles, String verificationCode) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userContact = userContact;
		this.gender = gender;
		this.isAdmin = isAdmin;
		this.isActive = isActive;
		this.accountCreationDate = accountCreationDate;
		this.isBlocked = isBlocked;
		this.oneTimePassword = oneTimePassword;
		this.otpRequestedTime = otpRequestedTime;
		this.roles = roles;
		this.verificationCode = verificationCode;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userEmail="
				+ userEmail + ", userContact=" + userContact + ", gender=" + gender + ", isAdmin=" + isAdmin
				+ ", isActive=" + isActive + ", accountCreationDate=" + accountCreationDate + ", isBlocked=" + isBlocked
				+ ", oneTimePassword=" + oneTimePassword + ", otpRequestedTime=" + otpRequestedTime + ", roles=" + roles
				+ ", verificationCode=" + verificationCode + "]";
	}

	
}
