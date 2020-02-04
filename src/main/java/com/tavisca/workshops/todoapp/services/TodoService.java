package com.tavisca.workshops.todoapp.services;

import com.tavisca.workshops.todoapp.model.Todo;
import com.tavisca.workshops.todoapp.repository.TodoDao;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoDao todoDao;


    public Iterable<Todo> getTodos() {
        return todoDao.findAll();
    }

    public Todo getTodoById(int todoId) {
        return todoDao.findById(todoId)
                .orElseThrow(RuntimeException::new);
    }

    public Todo addTodo(String json) {
        String todoName = new JSONObject(json).getString("todoname");
        Todo todo = new Todo();
        todo.setTodoname(todoName);
        return todoDao.save(todo);
    }

    public Todo updateTodo(int todoId, String json) {
        String todoName = new JSONObject(json).getString("todoname");
        Todo todo = new Todo(todoId, todoName);
        return todoDao.save(todo);
    }

    public JSONObject deleteTodo(int todoId) {
        todoDao.deleteById(todoId);
        return new JSONObject().put("status", "OK");
    }
}