package com.qintess.tasks.repositories;

import org.springframework.data.repository.CrudRepository;

import com.qintess.tasks.entities.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {

}
