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
@Table(name="patient_visit_sign")
@NoArgsConstructor
public class PatientVisitSigns {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int patient_visit_id;
    private String weight;
    private String height;
    private String blood_pressure;
    private String respiration_rate;
    
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patientId")
	private Patient patient;
}
