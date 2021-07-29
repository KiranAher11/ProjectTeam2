package com.kiranaher;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUserEmail(userEmail);
		
		System.out.println("/////////////////////////////////////////////////////");
		System.out.println(user);
		
		user.orElseThrow(() -> new UsernameNotFoundException("user not found"));
		
		return user.map(MyUserDetails::new).get();
	
	}

}
