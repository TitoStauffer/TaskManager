package com.taskmanager.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.taskmanager.model.Task;
import com.taskmanager.repository.TaskRepository;

@RestController
@RequestMapping("/tarefas")
public class TaskResource {

	@Autowired
	private TaskRepository taskRepository;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		List<Task>resultTasks = this.taskRepository.findAll();
		return resultTasks.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(resultTasks);
	}
	
	@PostMapping
	public ResponseEntity<Task> createTask(@Valid @RequestBody Task task, HttpServletResponse response) {
		Task newTask = this.taskRepository.save(task);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
											 .path("/id")
											 .buildAndExpand(newTask.getId())
											 .toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(newTask);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Task> foundedTask = this.taskRepository.findById(id); 
		return foundedTask.isEmpty() ?  ResponseEntity.notFound().build() : ResponseEntity.ok(foundedTask); 
		
	}
}
