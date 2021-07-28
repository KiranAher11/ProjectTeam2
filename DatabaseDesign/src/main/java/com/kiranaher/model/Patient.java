package com.kiranaher.model;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="patients")
@NoArgsConstructor
@Data
public class Patient {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int patientId;
    private String title;
    private String firstName;
    private String lastName;
    private String patientEmail;
    private String contactNumber;
    private String dateOfBirth;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credential_id" , referencedColumnName = "credential_id")
    private Credential credential;
    

}
