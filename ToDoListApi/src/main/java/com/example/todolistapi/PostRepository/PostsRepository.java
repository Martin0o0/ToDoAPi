package com.example.todolistapi.PostRepository;

import org.springframework.data.jpa.repository.JpaRepository;


//연결할 Entity클래스와 기본키 타입 할당.
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
