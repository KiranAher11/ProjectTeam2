package com.kiranaher.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Table(name="patient_medication")
@NoArgsConstructor
@Data
public class PatientMedication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String strength;
	private String application_no;
	private String product_no;
	private String from;
	private String durg_name;
	private String reference_drug;
	

}
