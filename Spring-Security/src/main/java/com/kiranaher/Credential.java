package com.kiranaher;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Credential {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int credential_id;

	//private String patient_userName;
	// private String user_userName;
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_id", referencedColumnName = "patientId")
	private Patient patient;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User user;

	public int getCredential_id() {
		return credential_id;
	}

	public void setCredential_id(int credential_id) {
		this.credential_id = credential_id;
	}

	/*
	 * public String getPatient_userName() { return patient_userName; }
	 * 
	 * public void setPatient_userName(String patient_userName) {
	 * this.patient_userName = patient.getPatientEmail(); }
	 * 
	 * public String getUser_userName() { return user_userName; }
	 * 
	 * public void setUser_userName(String user_userName) { this.user_userName =
	 * user.getUserEmail(); }
	 */
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
