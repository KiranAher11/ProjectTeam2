package com.citiustech.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
//@Entity
//@Table(name = "medication")
public class Medication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long medicationId;
	
	@NotNull
	private String drugName;
	
	@NotNull
	private String medicationText;
	
	public Medication() {
		
	}

	public Medication(@NotNull String drugName, @NotNull String medicationText) {
		super();
		this.drugName = drugName;
		this.medicationText = medicationText;
	}
	
	

}
