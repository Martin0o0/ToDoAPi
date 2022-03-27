package com.example.todolistapi.Controller;


import com.example.todolistapi.PostRepository.PostsRepository;
import com.example.todolistapi.Service.PostService;
import com.example.todolistapi.TodoListApiApplication;
import com.example.todolistapi.dto.PostResDto;
import com.example.todolistapi.dto.PostSaveDto;
import com.example.todolistapi.dto.PostUpdateDto;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

//    //public PostController(PostService postService){
//        this.postService = postService;
//    }

//    @Autowired
//    private PostsRepository postsRepository;
//
//    @After("")
//    public void DeleteAll() throws Exception {
//        postsRepository.deleteAll();
  //  }

    @PostMapping("/post")
    public Long save(@RequestBody PostSaveDto postSaveDto) {
        System.out.println("등록되었습니다.");
        System.out.println(postSaveDto.getTitle());
        System.out.println(postSaveDto.getWhatToDo());
        return postService.save(postSaveDto);

    }

    @PutMapping("/put/{No}")
    public Long update(@PathVariable Long No, @RequestBody PostUpdateDto postUpdateDto){
        return postService.update(No, postUpdateDto);
    }

    @GetMapping("/get/{No}")
    public PostResDto findById(@PathVariable Long No){
        return postService.findByNo(No);
    }


//
//    public String PostTodo(@RequestBody ToDoInfo toDoInfo){
//        toDoInfo.setNo(TodoListApiApplication.ToDoList.size() + 1);
//        TodoListApiApplication.ToDoList.add(toDoInfo);
//        System.out.println(toDoInfo);
//        for(ToDoInfo s : TodoListApiApplication.ToDoList){
//            System.out.println(s);
//        }
//        return "Success";
//    }


}
