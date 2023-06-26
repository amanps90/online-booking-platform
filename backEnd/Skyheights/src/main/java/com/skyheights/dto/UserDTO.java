package com.skyheights.dto;

public class UserDTO {
	private String userName;
	private String userPassword;
	private String userEmail;
	private String userContact;
	private String gender;
	
	public UserDTO() {
	}

	public UserDTO(String userName, String userPassword, String userEmail, String userContact, String gender) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userContact = userContact;
		this.gender = gender;
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

	@Override
	public String toString() {
		return "UserDTO [userName=" + userName + ", userPassword=" + userPassword + ", userEmail=" + userEmail
				+ ", userContact=" + userContact + ", gender=" + gender + "]";
	}
	
	
}
