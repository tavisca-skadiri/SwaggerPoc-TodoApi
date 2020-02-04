package com.tavisca.workshops.todoapp.controllers;

import com.tavisca.workshops.todoapp.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping(path = "/todos")
    public ResponseEntity<?> get() {
        return ResponseEntity.ok().body(
                todoService.getTodos());
    }

    @GetMapping(path = "/todos/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int todoId) {
        return ResponseEntity.ok().body(
                todoService.getTodoById(todoId));
    }

    @PostMapping(path = "/todos")
    public ResponseEntity<?> add(@RequestBody String jsonRequest) {
        return ResponseEntity.ok().body(todoService.addTodo(jsonRequest));
    }

    @PutMapping(path = "/todos/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int todoId, @RequestBody String jsonRequest) {
        return ResponseEntity.ok().body(todoService.updateTodo(todoId, jsonRequest));
    }

    @DeleteMapping(path = "/todos/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable("id") int todoId) {
        return ResponseEntity.ok().body(todoService.deleteTodo(todoId));
    }
}