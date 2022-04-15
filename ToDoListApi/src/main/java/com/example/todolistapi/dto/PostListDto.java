package com.example.todolistapi.dto;


import com.example.todolistapi.PostRepository.Posts;
//import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.time.LocalTime;


@Getter
public class PostListDto {
    @ApiModelProperty(value = "등록번호", example = "1", required = true)
    private Long No;
    @ApiModelProperty(value = "제목", example = "today is ..", required = true)
    private String title;
    @ApiModelProperty(value = "상세내용", example = "I'm going to ..", required = true)
    private String whatToDo;
    @ApiModelProperty(value = "시작시간", example = "00:01", required = true)
    private LocalTime whenToDo;
    @ApiModelProperty(value = "소요시간", example = "1~24", required = true)
    private Integer howLongToDo;
    @ApiModelProperty(value = "최종변경시간", example = "24:00:00", required = true)
    private LocalTime ModityTime;
    @ApiModelProperty(value = "완료여부", example = "true", required = true)
    private Boolean isComplete;
    @ApiModelProperty(value = "예상종료시간", example = "00:01", required = true)
    private LocalTime expectedTime;

    public PostListDto(Posts posts){
        this.No = posts.getNo();
        this.title = posts.getTitle();
        this.whatToDo = posts.getWhatToDo();
        this.whenToDo = posts.getWhenToDo();
        this.howLongToDo = posts.getHowLongToDo();
        this.ModityTime = posts.getModityTime();
        this.isComplete = posts.getIsComplete();
        this.expectedTime = posts.getExpectedTime();
    }
}
