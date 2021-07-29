package com.kiranaher.model;

import java.util.Date;

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
@Table(name="patient_procedure")
@NoArgsConstructor
public class PatientProcedure {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String procedure_description;
	private String procedure_code;
	private String created_by;
	private Date created_date_time;
	private int patient_visit_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patientId")
	private Patient patient;
}
