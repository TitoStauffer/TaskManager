package com.taskmanager.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.model.User;
import com.taskmanager.repository.UserRepository;

@RestController
@RequestMapping("/usuarios")
public class UserResource {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> findAll(){
		return this.userRepository.findAll();
	}
}
