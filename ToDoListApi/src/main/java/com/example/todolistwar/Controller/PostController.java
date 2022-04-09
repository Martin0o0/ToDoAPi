package com.example.todolistwar.Controller;

import com.example.todolistwar.Service.PostService;
import com.example.todolistwar.dto.PostSaveDto;
import com.example.todolistwar.dto.PostUpdateDto;
import com.example.todolistwar.dto.PostUpdateIsCompleteDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {

    private final PostService postService;


    @PostMapping("/post")
    public Long save(@RequestBody PostSaveDto postSaveDto) {


        log.info(postSaveDto.getTitle());

        log.info(postSaveDto.getWhatToDo());

        log.info(postSaveDto.getWhatToDo());

        log.info(postSaveDto.getHowLongToDo().toString());

        return postService.save(postSaveDto);

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


//
//    @GetMapping("/get/{No}")
//    public PostListDto findByNo(@PathVariable Long No) {
//        return postService.findByNo(No);
//    }

}
