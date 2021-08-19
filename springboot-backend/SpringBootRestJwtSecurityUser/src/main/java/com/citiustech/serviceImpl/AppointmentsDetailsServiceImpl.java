package com.citiustech.serviceImpl;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.mapper.EmailDtoMapper;
import com.citiustech.model.AppointmentDetails;
import com.citiustech.repo.AppointmentDetailsRepository;
import com.citiustech.service.AppinmentDetailsService;
import com.citiustech.service.EmailService;

@Service
public class AppointmentsDetailsServiceImpl implements AppinmentDetailsService {
	

	@Autowired
	private AppointmentDetailsRepository appointmentdetailsRepository;

	@Autowired
	private EmailService emailService;

	@Override
	public AppointmentDetails bookAppointment(Long userId, AppointmentDetails appointment) throws MessagingException {
		
		System.out.println("###############");
		
		emailService.sendMail(EmailDtoMapper.appintmentToEmailDtomapper2(appointment));
		return appointmentdetailsRepository.save(appointment);
	}
	
	@Override
	public List<AppointmentDetails> getAppointmentsByPhysicianId(Long physicianId) {
		
		return appointmentdetailsRepository.getAppointmentsByPhysicianId(physicianId);
	}

	@Override
	public AppointmentDetails getAppointmentByPatientId(Long patientId) {
		return appointmentdetailsRepository.getAppointmentsByPatientId(patientId);
	}

	@Override
	public AppointmentDetails getAppointmentById(Long appointmentId) {
		AppointmentDetails appointment = appointmentdetailsRepository.getAppointmentByAppointmentId(appointmentId);
		return appointment;
	}

	@Override
	public AppointmentDetails updateAppointmentStatus(AppointmentDetails appointmentdetails) {

		AppointmentDetails updateAppointment = appointmentdetailsRepository.getOne(appointmentdetails.getAppointmentId());
		updateAppointment.setStatus(appointmentdetails.getStatus());

		return appointmentdetailsRepository.save(appointmentdetails);
	}

}
