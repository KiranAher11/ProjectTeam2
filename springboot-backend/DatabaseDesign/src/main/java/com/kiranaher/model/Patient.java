package com.kiranaher.model;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="patient")
@NoArgsConstructor
@Data
public class Patient {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="patientId")
    private int patientId;
    private String title;
    private String firstName;
    private String lastName;
    private String patientEmail;
    private String contactNumber;
    private String dateOfBirth;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    private Set<PatientAllergy> patientAllergies;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    private Set<PatientDiagnosis> patientDiagnosis;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    private Set<PatientMedication> patientMedications;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    private Set<PatientProcedure> patientProcedures;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    private Set<PatientVisit> patientVisits;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    private Set<PatientVisitSigns> patientVisitSigns;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    private Set<InboxPatient> inboxPatients;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "patient")
    private Set<PatientDetails> patientDetails;
}
