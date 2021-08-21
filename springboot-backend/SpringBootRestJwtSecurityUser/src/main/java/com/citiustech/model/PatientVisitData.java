package com.citiustech.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class PatientVisitData {
	
	private VitalSigns vitalSigns;
	
	private Diagnosis diagnosis;
	
	private Medication medication;
	
	private  Procedure procedure;

}
