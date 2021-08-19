package com.citiustech.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "timeSlot")
public class TimeSlot {
	
	@Id
	@Column(name = "slot_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long timeslotId;
	
	@Column(name = "day_week")
	private String dayWeek;
	
	@Column(name = "slot_start")
	private LocalTime slotStart;
	
	@Column(name = "slot_end")
	private LocalTime slotEnd;
	
	@Column(name = "slot_date")
	private LocalDate slotDate;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "physician_id")
    private long physicianId;
    
	  @OneToOne(mappedBy = "slot") 
	  @JoinColumn(name = "appointment_id")
	  private AppointmentDetails appointmentdetails;
}
