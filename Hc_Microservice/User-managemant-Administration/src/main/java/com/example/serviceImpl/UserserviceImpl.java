package com.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.userdao;

import com.example.model.User;
import com.example.service.userService;

@Service
public class UserserviceImpl implements userService{

	@Autowired
	userdao userdao;
	
	@Override
	public User saveadmin(User user) {
		
		System.out.println("Inside service");
	
		
		User a=userdao.save(user);
		
		System.out.println("##############");
		return a;
	}



}
