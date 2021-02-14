package com.qintess.tasks.repositories;

import org.springframework.data.repository.CrudRepository;

import com.qintess.tasks.entities.Task;

public interface TaskRepositoy extends CrudRepository<Task, Integer> {

}
