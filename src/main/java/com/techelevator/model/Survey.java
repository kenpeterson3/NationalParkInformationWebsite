package com.techelevator.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {
	
	@NotBlank @Email(message="Not a valid email address")
	private String emailAddress;
	
	@NotBlank
	private String state;
	
	@NotBlank
	private String activityLevel;
	
	@NotBlank
	private String parkCode;
	

	public String getEmail() {
		return emailAddress;
	}

	public void setEmail(String email) {
		this.emailAddress = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(String physical) {
		this.activityLevel = physical;
	}

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String favoritePark) {
		this.parkCode = favoritePark;
	}
	
	
}
