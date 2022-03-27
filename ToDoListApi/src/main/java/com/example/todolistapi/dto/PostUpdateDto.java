package com.example.todolistapi.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.PostUpdate;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWhatToDo() {
        return whatToDo;
    }

    public void setWhatToDo(String whatToDo) {
        this.whatToDo = whatToDo;
    }

    public String getWhenToDo() {
        return whenToDo;
    }

    public void setWhenToDo(String whenToDo) {
        this.whenToDo = whenToDo;
    }

    public Integer getHowLongToDo() {
        return howLongToDo;
    }

    public void setHowLongToDo(Integer howLongToDo) {
        this.howLongToDo = howLongToDo;
    }
}
