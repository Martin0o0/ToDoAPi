package com.example.todolistapi.dto;

import com.example.todolistapi.PostRepository.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class PostSaveDto {

    private String title;
    private String whatToDo;
    private String whenToDo;
    private Integer howLongToDo;


    @Builder //생성자
    public PostSaveDto(String title, String whatToDo, String whenToDo, Integer howLongToDo){
        this.title = title;
        this.whatToDo = whatToDo;
        this.whenToDo = whenToDo;
        this.howLongToDo = howLongToDo;
    }

    //toEntity를 통해서 Posts Entity에 보내주자!
    public Posts toEntity(){

        return Posts.builder().title(title).whatToDo(whatToDo).whenToDo(whenToDo).howLongToDo(howLongToDo).build();
    }


}
