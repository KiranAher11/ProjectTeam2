package com.citiustech.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.model.AppointmentDetails;
import com.citiustech.service.AppinmentDetailsService;

@RestController
@RequestMapping("/api/appointment")
//@CrossOrigin("*")
//@RequestMapping("")
public class AppointmentDetailsController {

	
	@Autowired
	private AppinmentDetailsService appointmentdetailsService;


	@PostMapping("/{userId}")
	//@PostMapping("/booking")
	public ResponseEntity<AppointmentDetails> bookAppointment(@RequestBody AppointmentDetails appointmentdetails, @PathVariable long userId) throws MessagingException {

		System.out.println("$$$$$$$$$$$$$$$");
		
		AppointmentDetails createdappointment = appointmentdetailsService.bookAppointment(userId, appointmentdetails);
		return new ResponseEntity<>(createdappointment, HttpStatus.CREATED);
	}

	
	@GetMapping("/physician/{physicianId}")
	public ResponseEntity<List<AppointmentDetails>> getAppointmentByPhysicianId(@PathVariable long physicianId) {
		return new ResponseEntity<List<AppointmentDetails>>(appointmentdetailsService.getAppointmentsByPhysicianId(physicianId), HttpStatus.OK);
	}

	@GetMapping("/patient/{patientId}")
	public ResponseEntity<AppointmentDetails> getAppointmentByPatientId(@PathVariable long patientId) {
		return new ResponseEntity<AppointmentDetails>(appointmentdetailsService.getAppointmentByPatientId(patientId), HttpStatus.OK);
	}

	@GetMapping("/{appointmentId}")
	public ResponseEntity<AppointmentDetails> getAppointmentByAppointmentId(@PathVariable long appointmentId) {
		return new ResponseEntity<AppointmentDetails>(appointmentdetailsService.getAppointmentById(appointmentId), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<AppointmentDetails> updateAppointment(@RequestBody AppointmentDetails appointmentdetails) {
		return  new ResponseEntity<AppointmentDetails>(appointmentdetailsService.updateAppointmentStatus(appointmentdetails),HttpStatus.OK);
	}

}
