package com.example.todolistapi.dto;

import com.example.todolistapi.PostRepository.Posts;
//import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;


@Setter
@Getter
@NoArgsConstructor
public class PostSaveDto {

    @ApiModelProperty(value = "제목", example = "today is ..", required = true)
    private String title;
    @ApiModelProperty(value = "상세내용", example = "I'm going to ..", required = true)
    private String whatToDo;
    @ApiModelProperty(value = "시작시간", example = "00:01", required = true)
    private LocalTime whenToDo;
    @ApiModelProperty(value = "소요시간", example = "1~24", required = true)
    private Integer howLongToDo;


    @Builder //생성자
    public PostSaveDto(String title, String whatToDo, LocalTime whenToDo, Integer howLongToDo){
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
