package com.example.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "candidate")
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Email
	@Column(name = "mail", unique=true)
	private String mail;
	
	@NotNull
	@Column(name = "phone")
	private String phone;
	
	@NotNull
	@Column(name = "location")
	private String location;
	
	@NotNull
	@Column(name = "status")
	private String status;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "job_location")
	private String jobLocation;
	
	@Column(name = "start_date")
	private String startDate;
	
	@Column(name = "roundInterview")
	private int roundInterview;
	
	@Column(name = "interviewerId")
	private long interviewerId;
	
	@Column(name = "hrId")
	private long hrId;
	
	public Candidate() {}

	public Candidate(@NotNull String name, @NotNull @Email String mail, @NotNull String phone, @NotNull String location,
			@NotNull String status, String title, String jobLocation, String startDate, int roundInterview,
			long interviewerId, long hrId) {
		super();
		this.name = name;
		this.mail = mail;
		this.phone = phone;
		this.location = location;
		this.status = status;
		this.title = title;
		this.jobLocation = jobLocation;
		this.startDate = startDate;
		this.roundInterview = roundInterview;
		this.interviewerId = interviewerId;
		this.hrId = hrId;
	}

	public int getRoundInterview() {
		return roundInterview;
	}

	public void setRoundInterview(int roundInterview) {
		this.roundInterview = roundInterview;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getInterviewerId() {
		return interviewerId;
	}

	public void setInterviewerId(long interviewerId) {
		this.interviewerId = interviewerId;
	}

	public long getHrId() {
		return hrId;
	}

	public void setHrId(long hrId) {
		this.hrId = hrId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	
}
