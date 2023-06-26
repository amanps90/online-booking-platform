package com.skyheights.dto;

public class OtpDto {
	private String userEmail;
	private String otp;
	
	public OtpDto() {
		
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public OtpDto(String userEmail, String otp) {
		super();
		this.userEmail = userEmail;
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "OtpDto [userEmail=" + userEmail + ", otp=" + otp + "]";
	}
	
	
}
