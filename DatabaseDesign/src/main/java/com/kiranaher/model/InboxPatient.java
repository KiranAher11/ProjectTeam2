package com.kiranaher.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inbox_patient")
@NoArgsConstructor
@Data
public class InboxPatient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String meetingTitle;
	private String decription;
	private String physician;
	private Date date;
	private String time;
	private String rescheduledHistory;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patientId")
	private Patient patient;
}
