package com.example.todolistwar.dto;

import com.example.todolistwar.PostRepository.Posts;
import lombok.Getter;

import java.time.LocalTime;


@Getter
public class PostListDto {
    private Long No;
    private String title;
    private String whatToDo;
    private LocalTime whenToDo;
    private Integer howLongToDo;
    private LocalTime ModityTime;
    private Boolean isComplete;
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
