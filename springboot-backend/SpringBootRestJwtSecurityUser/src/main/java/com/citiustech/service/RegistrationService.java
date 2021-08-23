package com.citiustech.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.citiustech.model.Admin;
import com.citiustech.model.Nurse;
import com.citiustech.model.Patient;
import com.citiustech.model.Physician;
import com.citiustech.repo.AdminRepository;
import com.citiustech.repo.NurseRepository;
import com.citiustech.repo.PatientRepository;
import com.citiustech.repo.PhysicianRepository;
import com.citiustech.request.SignUpRequest;

@Service
public class RegistrationService {
	
	@Autowired
	private PatientRepository patientRepository;
		
	@Autowired
	private NurseRepository nurseRepository;
	
	@Autowired
	private PhysicianRepository physicianRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	public String  registeredThePatient(SignUpRequest signupRequest) {
		Patient patient = new Patient(
				signupRequest.getEmail(),
				encoder.encode(signupRequest.getPassword()),
				signupRequest.getFirstName(),
				signupRequest.getLastName(),
				signupRequest.getContactNumber() ,
				signupRequest.getGender(),
				signupRequest.getDateOfBirth());
		
		patientRepository.save(patient);
		
		return "Patient registered successfully" ;
	}
	
	public String  registereTheNurse(SignUpRequest signupRequest) {
		Nurse nurse = new Nurse(
				signupRequest.getEmail(),
				//encoder.encode(signupRequest.getPassword()),
				signupRequest.getFirstName(),
				signupRequest.getLastName(),
				signupRequest.getContactNumber() ,
				signupRequest.getGender(),
				signupRequest.getDateOfBirth());
		
		nurseRepository.save(nurse);
		
		return "Employee registered successfully" ;
	}
	
	public String  registeredThePhysician(SignUpRequest signupRequest) {
		Physician physician = new Physician(
				signupRequest.getEmail(),
				encoder.encode(signupRequest.getPassword()),
				signupRequest.getFirstName(),
				signupRequest.getLastName(),
				signupRequest.getContactNumber() ,
				signupRequest.getGender(),
				signupRequest.getDateOfBirth(),
				signupRequest.getSpecialization());
		
		physicianRepository.save(physician);
		
		return "Physician registered successfully" ;
	}

	public String registereTheAdmin(@Valid SignUpRequest signupRequest) {
				Admin 	admin = new Admin(
				signupRequest.getEmail(),
				signupRequest.getFirstName(),
				signupRequest.getLastName(),
				signupRequest.getContactNumber() ,
				signupRequest.getGender(),
				signupRequest.getDateOfBirth());
		
		adminRepository.save(admin);
		
		return "Admin registered successfully" ;
	}
	
}
