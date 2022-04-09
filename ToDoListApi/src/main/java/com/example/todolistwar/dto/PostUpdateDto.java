package com.example.todolistwar.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class PostUpdateDto {
    private String title;
    private String whatToDo;
    private LocalTime whenToDo;
    private Integer howLongToDo;


    @Builder
    public PostUpdateDto(String title, String whatToDo, LocalTime whenToDo, Integer howLongToDo) {
        this.title = title;
        this.whatToDo = whatToDo;
        this.whenToDo = whenToDo;
        this.howLongToDo = howLongToDo;
    }

}
