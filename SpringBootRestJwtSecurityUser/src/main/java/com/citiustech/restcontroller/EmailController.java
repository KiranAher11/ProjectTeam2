package com.citiustech.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/send/{email}")
	public String sendPasswordToUser(@PathVariable String email) {
		
		boolean flag = userRepository.existsByEmail(email); 
		
		if(flag) {
		String message = "Your new password is : password@123";
		String subject = "Mail from CT Genaeral Hospital";
		service.sendSimpleEmail(email , message, subject);
		return "Email sent successfully";
		}		
		else {
			
			return "Please enter the registered email address";
		}
	}
}
