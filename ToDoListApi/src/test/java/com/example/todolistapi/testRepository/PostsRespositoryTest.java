package com.example.todolistapi.testRepository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.todolistapi.PostRepository.Posts;
import com.example.todolistapi.PostRepository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalTime;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@RequiredArgsConstructor
public class PostsRespositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @BeforeEach
    public void beforecleanup(){
        postsRepository.deleteAll();
    }


    @AfterEach
    public void aftercleanup(){
        postsRepository.deleteAll();
    }

    @Test
    void getData(){
        //given
        postsRepository.save(Posts.builder()
                .title("Junit5 적용")
                .whatToDo("junit 적용 상태 확인")
                .whenToDo(LocalTime.now())
                .howLongToDo(1).build());

        //when
        List<Posts> postslist = postsRepository.findAll();

        //then

        Posts posts = postslist.get(0);
        assertEquals(posts.getTitle(), "Junit5 적용");
        assertEquals(posts.getWhatToDo(), "junit 적용 상태 확인");



    }

}
