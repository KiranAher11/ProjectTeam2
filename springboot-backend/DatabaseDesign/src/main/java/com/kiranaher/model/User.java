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
@Table(name="user")
@NoArgsConstructor
public class User {


	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private int day;
    private int month;
    private int year;
    private String password;
    private String confirmPassword;
	
	
	
}


