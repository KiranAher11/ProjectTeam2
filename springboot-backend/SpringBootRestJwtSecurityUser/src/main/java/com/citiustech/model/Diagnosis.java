package com.citiustech.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
//@Entity
//@Table(name = "diagnosis")
public class Diagnosis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long diagnosisId;
	
	@NotNull
	private String diagnosisDescription;
	
	@NotNull
	private String diagnosisText;
	
	public Diagnosis() {
		
	}

	public Diagnosis(@NotNull String diagnosisDescription, @NotNull String diagnosisText) {
		super();
		this.diagnosisDescription = diagnosisDescription;
		this.diagnosisText = diagnosisText;
	}
	
	

}
