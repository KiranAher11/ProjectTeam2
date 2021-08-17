package com.kiranaher.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor

@Table(name="Patient_details")
public class PatientDetails {

	
	  @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private int patient_id;
      private String title;
      private String first_name;
      private String last_name;
      private String gender;
      private Date date_of_birth;
      private int age;
      private String email;
      private String language_known;
      private String contact_number;
      
      
      
      @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name = "addressId" , referencedColumnName = "addressId")
      private PatientAddress home_address;
      
      @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name = "kinId;" , referencedColumnName = "kinId")
      private Kin kin;
      
      @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name = "allergyId;" , referencedColumnName = "allergyId")
      private PatientAllergy patientAllergy;
      
      @OneToOne(fetch = FetchType.EAGER)
  	  @JoinColumn(name = "patientId")
  	  private Patient patient;
      
     
      
    
     
      	
}
