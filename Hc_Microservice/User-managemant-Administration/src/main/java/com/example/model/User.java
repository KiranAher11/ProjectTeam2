package com.example.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "\"User\"")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String gender;
	
	
	
	/*
	 * @ManyToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name="role_id") private Role role;
	 */
	
	 @Column(name = "active")
	 private int active;
	 
	 @ManyToMany(cascade=CascadeType.ALL)
	 @JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
	 private Set<Roles> roles;
	
		/*
		 * @ManyToOne(cascade = CascadeType.ALL)
		 * 
		 * @JoinColumn(name="title_id") private Title title;
		 */

	public int getId() {
		return id;
	}

	public void setAdminId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	
	  public Set<Roles> getRoles() { return roles; }
	  
	  public void setRoles(Set<Roles> roles) { this.roles = roles; }
	 
	
	 public int getActive() {
		  return active;
		 }

		 public void setActive(int active) {
		  this.active = active;
		 }

		

			/*
			 * public Title getTitle() { return title; }
			 * 
			 * public void setTitle(Title title) { this.title = title; }
			 */

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", gender=" + gender +  "]";
	}
	
	
	
	
	
}
