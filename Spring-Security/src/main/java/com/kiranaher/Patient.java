package com.kiranaher;



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

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}
    
    

}
