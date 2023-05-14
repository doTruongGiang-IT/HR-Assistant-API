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

import com.example.springboot.entity.Candidate;
import com.example.springboot.exception.ResuorceNotFoundException;
import com.example.springboot.repository.CandidateRepository;

@RestController
@RequestMapping("/api/v1/")
public class CandidateController {

	@Autowired
	CandidateRepository candidateRepository;
	
	// Get all employee
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("candidates")
	public List<Candidate> getAllCandidate() {
		return this.candidateRepository.findAll();
	}
	
	// Get employee by id
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("candidates/{id}")
	public ResponseEntity<Candidate> getCandidateById(@PathVariable(value = "id") long candidateId) {
		Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() -> new ResuorceNotFoundException("Candidate not found"));
		return ResponseEntity.ok().body(candidate);
	};
	
	// Create new employee
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("candidates")
	public Candidate createCandidate(@Valid @RequestBody Candidate candidate) {
		return candidateRepository.save(candidate);
	};
	
	// Update smart phone by id
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("candidates/{id}")
	public ResponseEntity<Candidate> updateCandidate(@PathVariable(value = "id") long candidateId, @Valid @RequestBody Candidate updateCandidate) {
		Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() -> new ResuorceNotFoundException("Candidate not found"));
		candidate.setName(updateCandidate.getName());
		candidate.setMail(updateCandidate.getMail());
		candidate.setPhone(updateCandidate.getPhone());
		candidate.setLocation(updateCandidate.getLocation());
		candidate.setStatus(updateCandidate.getStatus());
		candidate.setRoundInterview(updateCandidate.getRoundInterview());
		candidate.setTitle(updateCandidate.getTitle());
		candidate.setJobLocation(updateCandidate.getJobLocation());
		candidate.setStartDate(updateCandidate.getStartDate());
		candidate.setInterviewerId(updateCandidate.getInterviewerId());
		candidate.setHrId(updateCandidate.getHrId());
		Candidate editEmployee = candidateRepository.save(candidate);
		return ResponseEntity.ok().body(editEmployee);
	};
	
	// Delete smart phone by id
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("candidates/{id}")
	public Map<String, Boolean> deleteCandidate(@PathVariable(value = "id") long candidateId) {
		Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() -> new ResuorceNotFoundException("Candidate not found"));
		this.candidateRepository.delete(candidate);
		Map<String, Boolean> respone = new HashMap<>();
		respone.put("deleted: ", Boolean.TRUE);
		return respone;
	};
	
}
