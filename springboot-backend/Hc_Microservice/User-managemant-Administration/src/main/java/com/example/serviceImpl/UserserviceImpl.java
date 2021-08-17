package com.example.serviceImpl;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dao.RoleRepository;
import com.example.dao.UserRepository;
import com.example.model.Role;
import com.example.model.User;
import com.example.service.UserService;

@Service("UserService")
public class UserserviceImpl implements UserService{

	 @Autowired(required=true)
	 private UserRepository userRepository;
	 
	 @Autowired(required=true)
	 private RoleRepository roleRepository;
	 
		
		  @Autowired(required=true) 
		  private PasswordEncoder passwordEncoder;
		 
	 
	 @Override
		public void saveUser(User user) {
			
			user.setPassword(passwordEncoder().encode(user.getPassword()));
			  user.setActive(1);
			  Role userRole = roleRepository.findByRole("ADMIN");
			  user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
			  userRepository.save(user);
			
		}

	    @Bean
		public PasswordEncoder passwordEncoder() {
		// TODO Auto-generated method stub
			return new BCryptPasswordEncoder();
	}

		@Override
		public User findUserByEmail(String email) {
			// TODO Auto-generated method stub
			return userRepository.findByEmail(email);
		}




}
