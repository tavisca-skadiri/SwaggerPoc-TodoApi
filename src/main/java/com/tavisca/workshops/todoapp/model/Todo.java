package com.tavisca.workshops.todoapp.model;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String todoname;

    public Todo() {
    }

    public Todo(int id, String todoname) {
        this.id = id;
        this.todoname = todoname;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", todoname='" + todoname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodoname() {
        return todoname;
    }

    public void setTodoname(String todoname) {
        this.todoname = todoname;
    }
}
