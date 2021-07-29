package com.kiranaher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	UserRepository repo;
	
	@RequestMapping("/")
	public String home() {
		return ("<h1>Welcome</h1>");
	}
	
	@RequestMapping("/user")
	public String getUser() {
		return ("<h1>Welcome User</h1>");
	}
	
	@RequestMapping("/admin")
	public String getAdmin() {
		return ("<h1>Welcome Admin</h1>");
	}
	
	@PostMapping("/user/save")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user1 = repo.save(user);
		return new ResponseEntity<User>(user1,HttpStatus.OK);
	}
	
}
