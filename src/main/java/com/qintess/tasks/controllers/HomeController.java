package com.qintess.tasks.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qintess.tasks.controllers.dto.TaskDto;
import com.qintess.tasks.repositories.TaskRepository;

@Controller
public class HomeController {
	
	@Autowired
	private TaskRepository taskRepository;

	@RequestMapping("")
	public String home(Model model) {
		model.addAttribute("tasks", returnTasksDto());
		return "index";
	}

	private List<TaskDto> returnTasksDto() {
		List<TaskDto> tasksDto = new ArrayList<>();
		taskRepository.findAll().forEach(task -> {
			tasksDto.add(new TaskDto(task));
		});
		return tasksDto;
	}
	
}
