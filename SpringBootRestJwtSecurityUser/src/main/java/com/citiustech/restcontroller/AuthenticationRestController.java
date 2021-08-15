package com.citiustech.restcontroller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.model.ERole;
import com.citiustech.model.Role;
import com.citiustech.model.User;
import com.citiustech.model.UserDetailsImpl;
import com.citiustech.repo.UserRepository;
import com.citiustech.request.LoginRequest;
import com.citiustech.request.SignUpRequest;
import com.citiustech.response.JwtResponse;
import com.citiustech.response.MessageResponse;
import com.citiustech.util.JwtUtils;
import com.citiustech.util.RolesUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthenticationRestController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RolesUtils rolesUtils;
	
	@Autowired
	private PasswordEncoder encoder;
	
	//login
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
		
		//check for Authentication
		Optional<User> user= userRepository.findByEmail(loginRequest.getEmail());
		boolean isPasswordMatches = encoder.matches(loginRequest.getPassword(), user.get().getPassword());
	 
		System.out.println(user.get());
		System.out.println(isPasswordMatches);
		
		if(user.isPresent() && isPasswordMatches) {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken
					(loginRequest.getEmail(),
					loginRequest.getPassword()));
			
			
			//set as SecurityContext(Authentication)
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			//Generate JWT Token
			String jwt = jwtUtils.generateToken(authentication);
			
			//current user object
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
			
			Optional <String> role = userDetails.getAuthorities()
												.stream()
												.map(auth ->auth.getAuthority())
												.findFirst();
			
			//return response
			return ResponseEntity.ok(
					new JwtResponse(
							jwt,//token 
							"bearer",
							userDetails.getId(),//id
							userDetails.getEmail(),
							role.get().toString()
							
							/*userDetails.getAuthorities()
							.stream()
							.map(auth ->auth.getAuthority())
							.collect(Collectors.toSet())*/ //Set<String> 
							
							)
					);
		}
		else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		}
	
	//register
	@PostMapping("/register")
	public ResponseEntity<?> createUser(@Valid @RequestBody SignUpRequest signupRequest){
		
		System.out.println(signupRequest.getFirstName());
		System.out.println(signupRequest.getLastName());
		//check username exist
		if(userRepository.existsByEmail(signupRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new 
						MessageResponse("Error: EmailId Already exist"));
		}
		
		//create user
		User user = new User(
				signupRequest.getEmail(),
				encoder.encode(signupRequest.getPassword()),
				signupRequest.getFirstName(),
				signupRequest.getLastName(),
				signupRequest.getContactNumber() ,
				signupRequest.getGender(),
				signupRequest.getDateOfBirth());
		
		//roles given by UI
		
		String usrRoles = signupRequest.getRole();
		
		//roles need to stored in DB
		Set<Role> dbRoles = new HashSet<>();
		
		rolesUtils.mapRoles(usrRoles, dbRoles);
		user.setRoles(dbRoles);
		userRepository.save(user);
		
		return ResponseEntity.ok(new MessageResponse("User Registered Successfully!"));
				
	}
	
	

	
}
