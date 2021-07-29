package com.kiranaher.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiranaher.model.Credential;
import com.kiranaher.model.Patient;
import com.kiranaher.model.User;

@RestController
@CrossOrigin("/api/v1")
public class HomeResource{
	
	@Autowired
	private UserRepositoy userRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@GetMapping("/login")
	public String login() {
		
		return ("<h1>Welcome</h1>");
	}
	
	
	@GetMapping("/")
	public String home() {
		return ("<h1>Welcome</h1>");
	}
	
	@GetMapping("/user")
	public String user() {
		return ("<h1>Welcome User</h1>");
	}
	
	@GetMapping("/admin")
	public String admin() {
		return ("<h1>Welcome Admin</h1>");
	}
	
	@PostMapping(path="/patient/save",consumes = "application/json")
	public ResponseEntity<Patient> addNewPatient(@RequestBody Patient patient){
		//Credential cred = new Credential();
		
		Patient user1 = patientRepository.save(patient);
		return new ResponseEntity<Patient>(user1 , HttpStatus.OK);
	}
	
	@PostMapping(path="/user/save",consumes = "application/json")
	public ResponseEntity<User> addNewUser(@RequestBody User user){
		
		User user1= userRepository.save(user);
		return new ResponseEntity<User>(user1 , HttpStatus.OK);
	}
}
