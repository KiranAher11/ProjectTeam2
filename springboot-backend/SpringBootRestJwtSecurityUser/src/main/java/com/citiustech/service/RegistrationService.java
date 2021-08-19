package com.citiustech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.citiustech.model.Employee;
import com.citiustech.model.Patient;
import com.citiustech.model.Physician;
import com.citiustech.repo.EmployeeRepository;
import com.citiustech.repo.PatientRepository;
import com.citiustech.repo.PhysicianRepository;
import com.citiustech.request.SignUpRequest;

@Service
public class RegistrationService {
	
	@Autowired
	private PatientRepository patientRepository;
		
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private PhysicianRepository physicianRepository;
	
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
	
	public String  registeredTheEmployee(SignUpRequest signupRequest) {
		Employee employee = new Employee(
				signupRequest.getEmail(),
				encoder.encode(signupRequest.getPassword()),
				signupRequest.getFirstName(),
				signupRequest.getLastName(),
				signupRequest.getContactNumber() ,
				signupRequest.getGender(),
				signupRequest.getDateOfBirth());
		
		employeeRepository.save(employee);
		
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
}
