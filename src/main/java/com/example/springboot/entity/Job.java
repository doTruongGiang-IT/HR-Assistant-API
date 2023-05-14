package com.example.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "job")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 5, message = "Job title should have at least 5 characters")
	@Column(name = "title")
	private String title;
	
	@NotNull
	@Column(name = "description")
	private String description;
	
	@Column(name = "job_title")
	private String jobTitle;
	
	@Column(name = "interviewerId")
	private long interviewerId;
	
	@Column(name = "hrId")
	private long hrId;
	
	public Job() {}

	public Job(@NotNull @Size(min = 5, message = "Job title should have at least 5 characters") String title,
			@NotNull String description, String jobTitle, long interviewerId, long hrId) {
		super();
		this.title = title;
		this.description = description;
		this.jobTitle = jobTitle;
		this.interviewerId = interviewerId;
		this.hrId = hrId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	
}
