package com.example.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 5, message = "User name should have at least 5 characters")
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Email
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Size(min = 8, message = "Password should have at least 8 characters")
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Size(min = 10, message = "Phone should have at least 10 digits")
	@Column(name = "phone")
	private String phone;
	
	@NotNull
	@Column(name = "role")
	private String role;
	
	public User() {}

	public User(@NotNull @Size(min = 5, message = "User name should have at least 5 characters") String name,
			@NotNull @Email String email,
			@NotNull @Size(min = 8, message = "Password should have at least 8 characters") String password,
			@NotNull @Size(min = 10, message = "Phone should have at least 10 digits") String phone,
			@NotNull String role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	};

	
}
