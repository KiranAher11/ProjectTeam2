package com.citiustech.request;

import java.util.Date;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.citiustech.model.EGender;

import lombok.Data;
import lombok.NonNull;

@Data
public class SignUpRequest {
	
	@NotNull
	@Size(max = 25)
	private String firstName;

	@Size(max = 25)
	private String lastName;

	@NotBlank
	@Size(max = 50)
	@Email
	@NonNull
	private String email;

	@Size(max = 15)
	private String contactNumber;

	@Enumerated(EnumType.STRING)
	private EGender gender;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@NotBlank
	@Size(max = 120)
	@NonNull
	private String password;

	@NotBlank
	@Size(max = 120)
	@NonNull
	private String confirmPassword;
	
    //private HashSet<String> role;
	
	private String role;

}
