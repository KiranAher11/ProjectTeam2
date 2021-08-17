package com.kiranaher.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
//@Entity
@Table(name="provider")
@NoArgsConstructor
public class Provider {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private int employee_id;
	private String first_name;
	private String last_name;
	private Date date_of_birth;
	private User user_id;
	
	
	
}
