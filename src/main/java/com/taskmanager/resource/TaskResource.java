package com.taskmanager.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.model.Task;
import com.taskmanager.repository.TaskRepository;

@RestController
@RequestMapping("/tarefas")
public class TaskResource {

	@Autowired
	private TaskRepository taskRepository;
	
	@GetMapping
	public List<Task> findAll(){
		return this.taskRepository.findAll();
	}
}
