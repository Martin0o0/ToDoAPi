package com.example.todolistapi.Controller;


import com.example.todolistapi.Service.PostService;
import com.example.todolistapi.dto.PostListDto;
import com.example.todolistapi.dto.PostSaveDto;
import com.example.todolistapi.dto.PostUpdateDto;
import com.example.todolistapi.dto.PostUpdateIsCompleteDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {

    private final PostService postService;


    @PostMapping("/post")
    public String save(@RequestBody PostSaveDto postSaveDto) {


        log.info(postSaveDto.getTitle());

        log.info(postSaveDto.getWhatToDo());

        log.info(postSaveDto.getWhatToDo());

        log.info(postSaveDto.getHowLongToDo().toString());

        return "추가된 등록번호" + Long.toString(postService.save(postSaveDto));

    }


    @PutMapping("/put/{No}")
    public Long update(@PathVariable Long No, @RequestBody PostUpdateDto postUpdateDto){
        return postService.update(No, postUpdateDto);
    }

    @PutMapping("/put/complete/{No}")
    public Long updateiscomlete(@PathVariable Long No, @RequestBody PostUpdateIsCompleteDto CompleteDto){
        return postService.updateComplete(No, CompleteDto);
    }

    @DeleteMapping("/delete/{No}")
    public Long delete(@PathVariable Long No){
        return postService.delete(No);
    }

    @GetMapping("/get/{No}")
    public PostListDto findByNo(@PathVariable Long No) {
        return postService.findByNo(No);
    }

    @GetMapping("/get")
    public List<PostListDto> findbyAll(){
        return postService.findByAll();
    }
}
