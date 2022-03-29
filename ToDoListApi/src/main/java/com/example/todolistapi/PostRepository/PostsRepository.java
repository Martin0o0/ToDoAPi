package com.example.todolistapi.PostRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;


//연결할 Entity클래스와 기본키 타입 할당.
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("Select p from Posts p order by p.no DESC ") //db로 별명을 붙여서 관리하기 편하게
    List<Posts> findAllDesc();



}
