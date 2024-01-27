package com.example.demo.requestDto;

import java.util.Date;
import java.util.UUID;


import com.example.demo.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomerDetailsModifyReqDto {

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	private UUID id;
	private String firstName;

	private String lastName;


	private Date dob;

	private String mobileNumber;

	private String aadharNumber;

	private Gender gender;


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
}
