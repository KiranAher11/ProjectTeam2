package com.citiustech.service;

import java.util.List;
import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

import com.citiustech.model.AppointmentDetails;



@Service
public interface AppinmentDetailsService {
	
	AppointmentDetails bookAppointment(Long userId, AppointmentDetails appointment) throws MessagingException;
	
	AppointmentDetails getAppointmentById(Long appointmentId);
	
	AppointmentDetails updateAppointmentStatus(AppointmentDetails appointment);
	
	List<AppointmentDetails> getAppointmentsByPhysicianId(Long physicianId);
	
	AppointmentDetails getAppointmentByPatientId(Long patientId);

	//New One
	//Appointment scheduleAppointment(Long userId, AppointmentInfo appointmentInfo);

}
