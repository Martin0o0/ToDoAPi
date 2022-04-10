package com.example.todolistapi.PostRepository;

import com.example.todolistapi.dto.PostListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;


//연결할 Entity클래스와 기본키 타입 할당.
public interface PostsRepository extends JpaRepository<Posts, Long> {

//    @Modifying //작성된 조회를제오한 데이터의 변경이 있는 경우 필요한 어노테이션.
//    @Query("Select p from Posts p order by p.no DESC ") //db로 별명을 붙여서 관리하기 편하게
//    List<Posts> findAllDesc();

    Page<Posts> findByTitleContaining(String keyword, Pageable pageable); //Title이라는 컬럼에서, 키값을 포함하는 것들을 찾아서 리스트로 반환.

    List<Posts> findByTitleContaining(String keyword); //Json객체로 반환.

    Page<Posts> findByIsComplete(Boolean isComplete, Pageable pageable); //완료되었는지를 찾아서 페이지로 반환.

    List<Posts> findByIsComplete(Boolean istrue);







}
