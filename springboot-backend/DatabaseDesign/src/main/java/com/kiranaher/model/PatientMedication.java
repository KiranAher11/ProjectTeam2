package com.kiranaher.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
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
	private String fromDate;
	private String durg_name;
	private String reference_drug;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patientId")
	private Patient patient;
}
