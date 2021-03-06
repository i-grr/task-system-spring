package com.qintess.tasks.controllers.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.qintess.tasks.entities.Task;

public class TaskDto {
	
	private Integer id;
	
	@NotNull
	@NotBlank(message = "The name field cannot be empty.")
	private String name;
	
	@NotNull
	@NotBlank(message = "The description field cannot be empty.")
	private String description;
	
	@NotNull
	@NotBlank(message = "The scheduling date field cannot be empty.")
	private String schedulingDate;
	
	@NotNull
	@NotBlank
	private String creationDate;
	
	public TaskDto() {}

	public TaskDto(Task task) {
		this.id = task.getId();
		this.name = task.getName();
		this.description = task.getDescription();
		this.schedulingDate = task.getSchedulingDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.creationDate = task.getCreationDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSchedulingDate() {
		return schedulingDate;
	}

	public void setSchedulingDate(String schedulingDate) {
		this.schedulingDate = schedulingDate;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public Task converter() {
		return new Task(this.id, this.name, this.description, LocalDate.parse(this.schedulingDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
	}

}
