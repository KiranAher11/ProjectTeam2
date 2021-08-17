package com.citiustech.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
//@Entity
//@Table(name="patient_address")
@Component
public class PatientAddress {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;
	private String street;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	
	public PatientAddress() {
		
	}
	
	public PatientAddress(String street, String city, String state, String country, String postalCode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
	}
	
	

}
