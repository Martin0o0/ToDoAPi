package com.example.todolistapi.PostRepository;


import com.example.todolistapi.TimeEntity.TimeEntity;
import lombok.*;

import javax.persistence.*;
import java.lang.annotation.Target;


@NoArgsConstructor
@Getter
@Setter
@Table(name="Posts")
@Entity
public class Posts extends TimeEntity { //시간을 설정할 수 있도록 설정해주자.
    @Id //등록할 때 마다 등록번호가 증가해야함으로, 기본키로 설정.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동으로 증가하도록 기본키 생성 규칙을 적용.
    private Long no;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String whatToDo;

    @Column(nullable = false)
    private String whenToDo;


    @Column(nullable = false)
    private Integer howLongToDo;

    private Boolean isComplete;



    @Builder //생성자 생성 => 빌더 패턴 클래스를 생성해 주자.
    public Posts(String title, String whatToDo, String whenToDo, Integer howLongToDo){
        this.title = title;
        this.whatToDo = whatToDo;
        this.whenToDo = whenToDo;
        this.howLongToDo = howLongToDo;
        this.isComplete = false;

    }

    public void update(String title, String whatToDo, String whenToDo, Integer howLongToDo){
        this.title = title;
        this.whatToDo = whatToDo;
        this.whenToDo = whenToDo;
        this.howLongToDo = howLongToDo;
        this.isComplete = getIsComplete();
    }

    public void updateComplete(Boolean isComplete){
        this.isComplete = isComplete;
    }

}
