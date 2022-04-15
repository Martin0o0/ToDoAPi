package com.example.todolistapi.Controller;


import com.example.todolistapi.Service.PostService;
import com.example.todolistapi.dto.PostListDto;
import com.example.todolistapi.dto.PostSaveDto;
import com.example.todolistapi.dto.PostUpdateDto;
import com.example.todolistapi.dto.PostUpdateIsCompleteDto;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.util.List;

@Api(tags = {"API 정보를 제공하는 Controller"})
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    @ApiOperation(value = "정보를 등록하는 메소드")
    @PostMapping("/post")
    public String save(@RequestBody PostSaveDto postSaveDto) {
        return "추가된 등록번호 " + Long.toString(postService.save(postSaveDto));

    }
    @ApiOperation(value = "정보를 갱신하는 메소드")
    @PutMapping("/put/{No}")
    public Long update( @ApiParam(value = "등록번호") @PathVariable Long No, @RequestBody PostUpdateDto postUpdateDto){
        return postService.update(No, postUpdateDto);
    }

   @ApiOperation(value = "완료여부를 갱신하는 메소드")
    @PutMapping("/put/complete/{No}")
    public Long updateiscomlete(@ApiParam(value = "완료여부를 갱신하는 메소드") @PathVariable Long No, @RequestBody PostUpdateIsCompleteDto CompleteDto){
        return postService.updateComplete(No, CompleteDto);
    }

    @ApiOperation(value = "정보를 삭제하는 메소드")
    @DeleteMapping("/delete/{No}")
    public Long delete(@ApiParam(value = "등록번호") @PathVariable Long No){
        return postService.delete(No);
    }


    @ApiOperation(value = "정보를 가져오는 메소드")
    @GetMapping("/get/{No}")
    public PostListDto findByNo(@ApiParam(value = "등록번호") @PathVariable Long No) {
        return postService.findByNo(No);
    }




    @ApiOperation(value = "모든 정보를 가져오는 메소드")
    @GetMapping("/get")
    public List<PostListDto> findbyAll(){
        return postService.findByAll();
    }


    @ApiOperation(value = "찾으려는 값을 토대로 검색하는 메소드")
    @GetMapping("/get/searchlist/{key}")
    public List<PostListDto> findBySearchwithkey(@ApiParam(value = "검색하려는 값")
                                                      @PathVariable String key){
        return postService.findbysearchlist(key);
    }
    @ApiOperation(value = "완료된 요소만 가져오는 메소드")
    @GetMapping("/get/completelist")
    public List<PostListDto> findByCompletelist(){
        return postService.findbyComplete();
    }

    @ApiOperation(value = "미완료된 요소만 가져오는 메소드")
    @GetMapping("/get/notcompletelist")
    public List<PostListDto> findByNotCompletelist(){
        return postService.findbyNotComplete();
    }
}
