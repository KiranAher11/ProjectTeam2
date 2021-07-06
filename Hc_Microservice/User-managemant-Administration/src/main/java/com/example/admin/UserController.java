package com.example.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.userService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	 @Autowired
	 userService users;
	
	@PostMapping("/add")
	public User addemp(@RequestBody User user)
	{
		System.out.println("Inside controller method body");
		
		User u=users.saveadmin(user);
		
		System.out.println("called mathod inside cotroller method");
		
		return u;
	
	}
}
