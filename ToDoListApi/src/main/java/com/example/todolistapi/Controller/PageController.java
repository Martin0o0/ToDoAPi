package com.example.todolistapi.Controller;


import com.example.todolistapi.Service.PostService;
import com.example.todolistapi.dto.PostListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class PageController {
    private final PostService postService;

    @RequestMapping("/")
    public String main(){
        return "mainpost";
    }

    @GetMapping("/todolist")
    public String ToDoList(Model model) { //머스테치에 객체를 보내주기 위해 가인수로 받자.
        model.addAttribute("posts", postService.findAllDesc());
        return "TodoList";
    }


    @GetMapping("/api/get/{No}")
    public String update(@PathVariable Long No, Model model) {
        PostListDto Dto = postService.findByNo(No);
        model.addAttribute("posts", Dto);

        return "testput";
    }



}
