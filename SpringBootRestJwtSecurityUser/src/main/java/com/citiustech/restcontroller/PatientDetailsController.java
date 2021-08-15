package com.citiustech.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.model.Kin;
import com.citiustech.model.PatientAddress;
import com.citiustech.model.PatientAllergy;
import com.citiustech.model.PatientDetails;
import com.citiustech.model.PatientDetailsData;
import com.citiustech.response.MessageResponse;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")

public class PatientDetailsController {
	
	//@Autowired
	//PatientDetailsRepository patientDetailsRepository;
	
	    //patientDetails
		@PostMapping("/patient")
		public ResponseEntity<?> createUser(@RequestBody(required=true) @Autowired(required=true)PatientDetailsData patientDetailsData){
			
			System.out.println(patientDetailsData.getPatientDetails().getFirstName());
			System.out.println(patientDetailsData.toString());
			
			PatientDetails details = new PatientDetails(patientDetailsData.getPatientDetails().getTitle(), patientDetailsData.getPatientDetails().getFirstName(),
					patientDetailsData.getPatientDetails().getLastName(), patientDetailsData.getPatientDetails().getContactNumber(), patientDetailsData.getPatientDetails().getEmail(), patientDetailsData.getPatientDetails().getAge(),
					patientDetailsData.getPatientDetails().getRace(), patientDetailsData.getPatientDetails().getEthnicity(), patientDetailsData.getPatientDetails().getLanguagesKnown(),patientDetailsData.getPatientDetails().getGender(),
					patientDetailsData.getPatientDetails().getDateOfBirth());
			
			Kin kin = new Kin(patientDetailsData.getKin().getEmail(), patientDetailsData.getKin().getContactNumber(), patientDetailsData.getKin().getEmail(), patientDetailsData.getKin().getFirstName(), patientDetailsData.getKin().getLastName(), patientDetailsData.getKin().getTitle());
			
			PatientAllergy allergy = new PatientAllergy(patientDetailsData.getPatientAllergy().getAllergy_id(), patientDetailsData.getPatientAllergy().getType());
			
			PatientAddress address = new PatientAddress(patientDetailsData.getAddress().getStreet(), patientDetailsData.getAddress().getCity(), patientDetailsData.getAddress().getState(), patientDetailsData.getAddress().getCountry(), patientDetailsData.getAddress().getPostalCode());
			
			//patientDetailsRepository.save(details);			
			return ResponseEntity.ok(new MessageResponse("Patient Saved Successfully!"));
					
		}

}
