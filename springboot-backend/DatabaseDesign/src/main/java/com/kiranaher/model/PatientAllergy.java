package com.kiranaher.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="patient_allergy")
@NoArgsConstructor
public class PatientAllergy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int allergyId;
	@Column(name="allergy_id")
	private String allergy_id;
	@Column(name="allergy_type")
	private String type;
	
}
