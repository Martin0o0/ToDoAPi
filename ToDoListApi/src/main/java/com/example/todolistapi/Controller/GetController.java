package com.example.todolistapi.Controller;

import com.example.todolistapi.dto.ToDoInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/get")
public class GetController {
    @GetMapping("/{userid}")
    public ToDoInfo getInfo(@PathVariable(name = "userid")ToDoInfo toDoInfo){
        System.out.println();
        return toDoInfo;
    }

}