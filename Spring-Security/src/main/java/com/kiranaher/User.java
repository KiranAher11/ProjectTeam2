package com.kiranaher;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="user")
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String title;
	private String firstName;
	private String lastName;
	private String userEmail;
	private String role;
	private String dateOfBirth;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "credential_id" , referencedColumnName = "credential_id")
    private Credential credential;
	
	
	
}


