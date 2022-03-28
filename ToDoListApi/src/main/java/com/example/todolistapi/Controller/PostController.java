package com.example.todolistapi.Controller;


import com.example.todolistapi.Service.PostService;
import com.example.todolistapi.dto.PostListDto;
import com.example.todolistapi.dto.PostSaveDto;
import com.example.todolistapi.dto.PostUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {
    private final PostService postService;


    @PostMapping("/post")
    public Long save(@RequestBody PostSaveDto postSaveDto) {

        System.out.println(postSaveDto.getTitle());
        System.out.println(postSaveDto.getWhatToDo());
        System.out.println(postSaveDto.getWhenToDo());
        System.out.println(postSaveDto.getHowLongToDo());
        return postService.save(postSaveDto);

    }

    @PutMapping("/put/{No}")
    public Long update(@PathVariable Long No, @RequestBody PostUpdateDto postUpdateDto) {
        return postService.update(No, postUpdateDto);
    }

    @GetMapping("/get/{No}")
    public PostListDto findById(@PathVariable Long No) {
        return postService.findByNo(No);
    }

}
