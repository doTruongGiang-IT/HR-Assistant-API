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

import com.example.springboot.entity.Interviewer;
import com.example.springboot.exception.ResuorceNotFoundException;
import com.example.springboot.repository.InterviewerRepository;

@RestController
@RequestMapping("/api/v1/")
public class InterviewerController {

	@Autowired
	InterviewerRepository interviewerRepository;
	
	// Get all employee
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("interviewers")
	public List<Interviewer> getAllInterviewer() {
		return this.interviewerRepository.findAll();
	}
	
	// Get employee by id
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("interviewers/{id}")
	public ResponseEntity<Interviewer> getInterviewerById(@PathVariable(value = "id") long interviewerId) {
		Interviewer interviewer = interviewerRepository.findById(interviewerId).orElseThrow(() -> new ResuorceNotFoundException("Interviewer not found"));
		return ResponseEntity.ok().body(interviewer);
	};
	
	// Create new employee
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("interviewers")
	public Interviewer createInterviewer(@Valid @RequestBody Interviewer interviewer) {
		return interviewerRepository.save(interviewer);
	};
	
	// Update smart phone by id
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("interivewers/{id}")
	public ResponseEntity<Interviewer> updateInterviewer(@PathVariable(value = "id") long interivewerId, @Valid @RequestBody Interviewer updateInterviewer) {
		Interviewer interviewer = interviewerRepository.findById(interivewerId).orElseThrow(() -> new ResuorceNotFoundException("Interviewer not found"));
		interviewer.setName(updateInterviewer.getName());
		interviewer.setEmail(updateInterviewer.getEmail());
		interviewer.setPhone(updateInterviewer.getPhone());
		Interviewer editEmployee = interviewerRepository.save(interviewer);
		return ResponseEntity.ok().body(editEmployee);
	};
	
	// Delete smart phone by id
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("interviewers/{id}")
	public Map<String, Boolean> deleteInterviewer(@PathVariable(value = "id") long interviewerId) {
		Interviewer interviewer = interviewerRepository.findById(interviewerId).orElseThrow(() -> new ResuorceNotFoundException("Interviewer not found"));
		this.interviewerRepository.delete(interviewer);
		Map<String, Boolean> respone = new HashMap<>();
		respone.put("deleted: ", Boolean.TRUE);
		return respone;
	};
	
}
