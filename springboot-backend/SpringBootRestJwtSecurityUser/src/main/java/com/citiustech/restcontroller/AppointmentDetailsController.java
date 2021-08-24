package com.citiustech.restcontroller;
import java.util.List;
import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.citiustech.model.AppointmentDetails;
import com.citiustech.service.AppinmentDetailsService;

//@CrossOrigin("*")
//@RequestMapping("")
@RestController
@RequestMapping("/bookapp")
public class AppointmentDetailsController {

	@Autowired
	private AppinmentDetailsService appointmentdetailsService;

	@PostMapping("/{userId}")
	//@PostMapping("/booking")                                         //, @PathVariable long userId
	public ResponseEntity<AppointmentDetails> bookAppointment(@Valid @RequestBody AppointmentDetails appointmentdetails , @PathVariable long userId) throws MessagingException {

		System.out.println("ADD servcie in mycontroller class");
		                                                                         //
		AppointmentDetails createdappointment = appointmentdetailsService.bookAppointment(userId,appointmentdetails);
		return new ResponseEntity<AppointmentDetails>(createdappointment, HttpStatus.CREATED);
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
