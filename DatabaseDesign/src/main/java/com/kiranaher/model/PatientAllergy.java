package com.kiranaher.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Entity
@Table(name="patient_allergy")
@NoArgsConstructor
public class PatientAllergy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int patient_visit_id;
	private String allergy_name;
	private String credated_by;
	private String allergy_description;
	
	private String isActive;
	
}
