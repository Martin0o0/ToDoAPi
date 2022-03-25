package com.example.todolistapi;

import com.example.todolistapi.dto.ToDoInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;

@SpringBootApplication
public class TodoListApiApplication {

    public static LinkedList<ToDoInfo> ToDoList = new LinkedList<>();
    public static void main(String[] args) {
        SpringApplication.run(TodoListApiApplication.class, args);
    }

}
