package com.example.todolistapi.PostRepository;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.lang.annotation.Target;


@NoArgsConstructor
@Table(name="Posts")
@Entity
public class Posts {
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

    @Builder //생성자 생성 => 빌더 패턴 클래스를 생성해 주자.
    public Posts(String title, String whatToDo, String whenToDo, Integer howLongToDo){
        this.title = title;
        this.whatToDo = whatToDo;
        this.whenToDo = whenToDo;
        this.howLongToDo = howLongToDo;
    }

    public void update(String title, String whatToDo, String whenToDo, Integer howLongToDo){
        this.title = title;
        this.whatToDo = whatToDo;
        this.whenToDo = whenToDo;
        this.howLongToDo = howLongToDo;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
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


    public String getWhenToDo() {
        return whenToDo;
    }

    public Integer getHowLongToDo() {
        return howLongToDo;
    }

}
