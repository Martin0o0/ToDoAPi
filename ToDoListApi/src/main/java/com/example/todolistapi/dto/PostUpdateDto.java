package com.example.todolistapi.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.PostUpdate;
@Getter
@Setter
@NoArgsConstructor
public class PostUpdateDto {
    private String title;
    private String whatToDo;
    private String whenToDo;
    private Integer howLongToDo;


    @Builder
    public PostUpdateDto(String title, String whatToDo, String whenToDo, Integer howLongToDo) {
        this.title = title;
        this.whatToDo = whatToDo;
        this.whenToDo = whenToDo;
        this.howLongToDo = howLongToDo;
    }

}
