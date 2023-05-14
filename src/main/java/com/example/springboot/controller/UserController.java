package com.example.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springboot.entity.User;
import com.example.springboot.exception.ResuorceNotFoundException;
import com.example.springboot.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	// Get all employee
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("users")
	public List<User> getAllUser() {
		return this.userRepository.findAll();
	}
	
	// Get employee by id
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new ResuorceNotFoundException("User not found"));
		return ResponseEntity.ok().body(user);
	};
	
	// Create new employee
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("users")
	public User createUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	};
	
	// Update smart phone by id
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") long userId, @Valid @RequestBody User updateUser) {
		User user = userRepository.findById(userId).orElseThrow(() -> new ResuorceNotFoundException("User not found"));
		user.setName(updateUser.getName());
		user.setEmail(updateUser.getEmail());
		user.setPhone(updateUser.getPhone());
		user.setPassword(user.getPassword());
		user.setRole(user.getRole());
		User editEmployee = userRepository.save(user);
		return ResponseEntity.ok().body(editEmployee);
	};
	
	// Delete smart phone by id
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("users/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new ResuorceNotFoundException("User not found"));
		this.userRepository.delete(user);
		Map<String, Boolean> respone = new HashMap<>();
		respone.put("deleted: ", Boolean.TRUE);
		return respone;
	};
	
}
