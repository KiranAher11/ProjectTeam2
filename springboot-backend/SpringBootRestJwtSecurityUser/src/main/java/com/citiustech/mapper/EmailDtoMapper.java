package com.citiustech.mapper;

import com.citiustech.model.AppointmentDetails;
import com.citiustech.model.EmailDto;

public class EmailDtoMapper {
	
	public static EmailDto appintmentToEmailDtomapper(AppointmentDetails appointmentdetails) {

		EmailDto emailDto = new EmailDto();
		emailDto.setPatientName("PatientName");
		emailDto.setPatientEmail("");
		emailDto.setPhysicianName(appointmentdetails.getPhysicianName());

		if(appointmentdetails.getStatus().equalsIgnoreCase("Active")) {

			emailDto.setStatus("Appointment Scheduled");
		}
		else {
			emailDto.setStatus("Appointment Canceled");
		}
		emailDto.setDate(appointmentdetails.getSlot().getSlotDate().toString());
		emailDto.setTime(appointmentdetails.getSlot().getSlotStart().toString() + "-" +appointmentdetails.getSlot().getSlotStart().toString());

		return emailDto;
	}
	
	public static EmailDto appintmentToEmailDtomapper2(AppointmentDetails appointmentdetails) {

		EmailDto emailDto = new EmailDto();
		
		emailDto.setPatientName(appointmentdetails.getPatientName());
		emailDto.setPatientEmail(appointmentdetails.getPatientEmail());
	
		emailDto.setPhysicianName(appointmentdetails.getPhysicianName());
		emailDto.setPhysicianEmail(appointmentdetails.getPhysicianEmail());

		
		if(appointmentdetails.getStatus().equalsIgnoreCase("Active")) {

			emailDto.setStatus("Appointment Scheduled");
		}
		else {
			emailDto.setStatus("Appointment Canceled");
		}

		emailDto.setDate(appointmentdetails.getSlot().getSlotDate().toString());
		emailDto.setTime(appointmentdetails.getSlot().getSlotStart().toString() + "-" +appointmentdetails.getSlot().getSlotStart().toString());

		return emailDto;
	}

}
