package com.taskmanager.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.taskmanager.model.User;
import com.taskmanager.repository.UserRepository;

@RestController
@RequestMapping("/usuarios")
public class UserResource {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		List<User> resultUsers = this.userRepository.findAll();
		return resultUsers.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(resultUsers);
	}
	
	@PostMapping
	public ResponseEntity<User> createTask(@RequestBody User user, HttpServletResponse response) {
		User newUser = this.userRepository.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
											 .path("/id")
											 .buildAndExpand(newUser.getId())
											 .toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(newUser);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<User>foundedUser = this.userRepository.findById(id); 
		return foundedUser.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(foundedUser);
	}
}
