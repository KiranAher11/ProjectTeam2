package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;
	private String firstName;
	private String lastName;
	private String password;
	private String gmail;
	private String gender;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="role_id")
	private Role role;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="title_id")
	private Title title;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "User [adminId=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName + ", gmail=" + gmail
				+ ", password=" + password + ", gender=" + gender + ", role=" + role + ", title=" + title + "]";
	}
	
	
	
	
	
}
