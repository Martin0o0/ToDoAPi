package com.example.todolistapi.dto;


import com.example.todolistapi.PostRepository.Posts;
import lombok.Getter;


public class PostResDto {
    private Long No;
    private String title;
    private String whatToDo;
    private String whenToDo;
    private Integer howLongToDo;

    public PostResDto(){
        this.title = "";
        this.whatToDo = "";
        this.whenToDo = "";
        this.howLongToDo = 0;
    }


    public PostResDto(Posts posts){
        this.No = posts.getNo();
        this.title = posts.getTitle();
        this.whatToDo = posts.getWhatToDo();
        this.whenToDo = posts.getWhenToDo();
        this.howLongToDo = posts.getHowLongToDo();
    }

    public Long getNo() {
        return No;
    }

    public void setNo(Long no) {
        No = no;
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
