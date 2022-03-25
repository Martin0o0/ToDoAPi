package com.example.todolistapi.Controller;


import com.example.todolistapi.TodoListApiApplication;
import com.example.todolistapi.dto.ToDoInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @PostMapping()
    public String PostTodo(@RequestBody ToDoInfo toDoInfo){
        toDoInfo.setNo(TodoListApiApplication.ToDoList.size() + 1);
        TodoListApiApplication.ToDoList.add(toDoInfo);
        System.out.println(toDoInfo);
        for(ToDoInfo s : TodoListApiApplication.ToDoList){
            System.out.println(s);
        }
        return "Success";
    }



}
