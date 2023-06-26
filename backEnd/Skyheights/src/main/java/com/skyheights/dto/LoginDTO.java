package com.skyheights.dto;

public class LoginDTO {
	private String userEmail;
	private String userPassword;

	public LoginDTO() {
		
	}

	public LoginDTO(String userEmail, String userPassword) {
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "LoginDTO [userEmail=" + userEmail + ", userPassword=" + userPassword + "]";
	}

}
