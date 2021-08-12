package com.kiranaher.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="patient_address")
@NoArgsConstructor
public class Kin {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int kinId;
	private String email;
	private Long contactNumber;
	private String relationship;
	private String firstName;
	private String lastName;
	private String title;

}
