package com.qintess.tasks.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qintess.tasks.controllers.dto.TaskDto;
import com.qintess.tasks.entities.Task;
import com.qintess.tasks.repositories.TaskRepository;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskRepository taskRepository;

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("task", new TaskDto());
		return "task/create";
	}
	
	@PostMapping("/add")
	public String add(@Valid TaskDto taskDto,
					  BindingResult result,
					  Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("error", "Error trying to create the task: " + result.getAllErrors().get(0).getDefaultMessage());
			model.addAttribute("task", taskDto);
			return "task/create";
		}
		
		Task task = taskDto.converter();
		taskRepository.save(task);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,
						 RedirectAttributes redirectAtt) {
		taskRepository.deleteById(id);
		redirectAtt.addFlashAttribute("success", "Task " + id + " successfully deleted.");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,
					   Model model) {
		var taskOptional = taskRepository.findById(id);
		if (taskOptional.isPresent()) {
			var task = taskOptional.get();
			var taskDto = new TaskDto(task);
			model.addAttribute("task", taskDto);
		}
		return "task/create";
	}
	
}
