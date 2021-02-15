package com.qintess.tasks.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {

	@RequestMapping("/create")
	public String create() {
		return "task/create";
	}
	
}
