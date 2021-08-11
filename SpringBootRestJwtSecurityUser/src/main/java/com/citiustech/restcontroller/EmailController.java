package com.citiustech.restcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.model.User;
import com.citiustech.repo.UserRepository;
import com.citiustech.service.EmailSenderService;

@RestController
@RequestMapping("/mail")
public class EmailController {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	EmailSenderService service;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@PostMapping("/sendEmail")
	public String sendPasswordToUser(@RequestBody ValidateEmail email) {
		
		Optional<User> flag = userRepository.findByEmail(email.getEmail());
		System.out.println("user is present");		
		if(flag.isPresent()) {
		String message = "Your new password is : password@123";
		String subject = "Mail from CT General Hospital";
		service.sendSimpleEmail(email.getEmail() , message, subject);
		
		Optional<User> user = userRepository.findByEmail(email.getEmail());
		user.ifPresent(e -> e.setPassword(encoder.encode("password@123")));
			if(user.isPresent()) {
				userRepository.save(user.get());
			}
		
			return "Email sent successfully";
		}		
		else {
			
			return "Please enter the registered email address";
		}
	}
	
	@PostMapping("/changePassword")
	public String changePassword(@RequestBody ValidateUser user1) {
		
		Optional<User> user = userRepository.findByEmail(user1.getEmail());
		user.ifPresent(e -> e.setPassword(encoder.encode(user1.getPassword())));
			if(user.isPresent()) {
				userRepository.save(user.get());
			}
		return "Password changed successfully";
	}
}
