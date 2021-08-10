package com.citiustech.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.model.PatientDetails;

import com.citiustech.repo.PatientDetailsRepository;
import com.citiustech.response.MessageResponse;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")

public class PatientDetailsController {
	
	@Autowired
	PatientDetailsRepository patientDetailsRepository;
	
	    //patientDetails
		@PostMapping("/patient")
		public ResponseEntity<?> createUser(@Valid @RequestBody PatientDetails patientDetails){
			
			System.out.println(patientDetails.getFirstName());
			System.out.println(patientDetails.getLastName());
			
			patientDetailsRepository.save(patientDetails);			
			return ResponseEntity.ok(new MessageResponse("Patient Saved Successfully!"));
					
		}

}
