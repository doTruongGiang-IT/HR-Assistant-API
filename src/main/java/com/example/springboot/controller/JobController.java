package com.example.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.Job;
import com.example.springboot.exception.ResuorceNotFoundException;
import com.example.springboot.repository.JobRepository;

@RestController
@RequestMapping("/api/v1/")
public class JobController {

	@Autowired
	JobRepository jobRepository;
	
	// Get all employee
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("jobs")
	public List<Job> getAllJob() {
		return this.jobRepository.findAll();
	}
	
	// Get employee by id
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("jobs/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable(value = "id") long jobId) {
		Job job = jobRepository.findById(jobId).orElseThrow(() -> new ResuorceNotFoundException("Job not found"));
		return ResponseEntity.ok().body(job);
	};
	
	// Create new employee
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("jobs")
	public Job createJob(@Valid @RequestBody Job job) {
		return jobRepository.save(job);
	};
	
	// Update smart phone by id
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("jobs/{id}")
	public ResponseEntity<Job> updateJob(@PathVariable(value = "id") long jobId, @Valid @RequestBody Job updateJob) {
		Job interviewer = jobRepository.findById(jobId).orElseThrow(() -> new ResuorceNotFoundException("Job not found"));
		interviewer.setTitle(updateJob.getTitle());
		interviewer.setDescription(updateJob.getDescription());
		interviewer.setJobTitle(updateJob.getJobTitle());
		interviewer.setInterviewerId(updateJob.getInterviewerId());
		interviewer.setHrId(updateJob.getHrId());
		interviewer.setListInterviewerId(updateJob.getListInterviewerId());
		Job editEmployee = jobRepository.save(interviewer);
		return ResponseEntity.ok().body(editEmployee);
	};
	
	// Delete smart phone by id
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("jobs/{id}")
	public Map<String, Boolean> deleteJob(@PathVariable(value = "id") long jobId) {
		Job job = jobRepository.findById(jobId).orElseThrow(() -> new ResuorceNotFoundException("Job not found"));
		this.jobRepository.delete(job);
		Map<String, Boolean> respone = new HashMap<>();
		respone.put("deleted: ", Boolean.TRUE);
		return respone;
	};
	
}
