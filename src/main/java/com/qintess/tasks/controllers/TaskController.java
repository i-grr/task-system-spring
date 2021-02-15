package com.qintess.tasks.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qintess.tasks.controllers.dto.TaskDto;
import com.qintess.tasks.entities.Task;
import com.qintess.tasks.repositories.TaskRepository;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskRepository taskRepository;

	@GetMapping("/create")
	public String create(@Valid Model model) {
		model.addAttribute("task", new TaskDto());
		return "task/create";
	}
	
	@PostMapping("/add")
	public String add(TaskDto taskDto) {
		Task task = taskDto.converter();
		taskRepository.save(task);
		return "redirect:/";
	}
	
}
