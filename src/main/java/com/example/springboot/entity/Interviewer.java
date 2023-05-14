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
@Table(name = "interviewer")
public class Interviewer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 5, message = "Interviewer name should have at least 5 characters")
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Email
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Size(min = 10, message = "Phone should have at least 10 digits")
	@Column(name = "phone")
	private String phone;
	
	public Interviewer() {}

	public Interviewer(@NotNull @Size(min = 5, message = "Interviewer name should have at least 5 characters") String name,
			@NotNull @Email String email,
			@NotNull @Size(min = 10, message = "Phone should have at least 10 digits") String phone) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
