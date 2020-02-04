package com.tavisca.workshops.todoapp.repository;

import com.tavisca.workshops.todoapp.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoDao extends CrudRepository<Todo, Integer> {

}