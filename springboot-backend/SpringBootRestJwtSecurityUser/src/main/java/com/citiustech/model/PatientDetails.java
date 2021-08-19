package com.citiustech.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(name = "patientDetails", uniqueConstraints = {
                @UniqueConstraint(columnNames = "email") })
@Component
public class PatientDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patient_details_id;
	
	@NotBlank
	@Size(max = 120)
	@NonNull
	private String title;
	
	@NotNull
	@Size(max = 25)
	private String firstName;

	@Size(max = 25)
	private String lastName;

	@Size(max = 15)
	private String contactNumber;

	@NotBlank
	@Size(max = 50)
	@Email
	@NonNull
	private String email;
	

	private int age;

	@NotBlank
	@Size(max = 120)
	@NonNull
	private String race;
	
	@NotBlank
	@Size(max = 120)
	@NonNull
	private String ethnicity;
	
	@NotBlank
	@Size(max = 120)
	@NonNull
	private String languagesKnown;
	

	@Enumerated(EnumType.STRING)
	private EGender gender;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "PatientAddress", joinColumns = @JoinColumn(name = "patient_details_id"), inverseJoinColumns = @JoinColumn(name = "addressId"))
	private PatientAddress patientAdress;
	
	
	public PatientDetails() {
		
	}


	public PatientDetails(@NotBlank @Size(max = 120) @NonNull String title, @NotNull @Size(max = 25) String firstName,
			@Size(max = 25) String lastName, @Size(max = 15) String contactNumber,
			@NotBlank @Size(max = 50) @Email @NonNull String email, int age,
			@NotBlank @Size(max = 120) @NonNull String race, @NotBlank @Size(max = 120) @NonNull String ethnicity,
			@NotBlank @Size(max = 120) @NonNull String languagesKnown, EGender gender, Date dateOfBirth , PatientAddress patientAddress) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.age = age;
		this.race = race;
		this.ethnicity = ethnicity;
		this.languagesKnown = languagesKnown;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.patientAdress = patientAddress;
	}
	
    
}
