package com.citiustech.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.citiustech.model.AppointmentDetails;

@Repository
public interface AppointmentDetailsRepository extends JpaRepository<AppointmentDetails, Long> {
	
         List<AppointmentDetails> getAppointmentsByPhysicianId(long physicianId);
	
          AppointmentDetails getAppointmentsByPatientId(long patientId);
	
          AppointmentDetails getAppointmentByAppointmentId(long appointmentId);
	
}
