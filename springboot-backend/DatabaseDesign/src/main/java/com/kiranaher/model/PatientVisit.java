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

@Data
@Entity
@Table(name="patient_visit")
@NoArgsConstructor
public class PatientVisit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int physician_id;
	private int allergy_master_id;
	private int patient_mrn;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patientId")
	private Patient patient;
}
