package com.example.todolistapi.Service;


import com.example.todolistapi.PostRepository.Posts;
import com.example.todolistapi.PostRepository.PostsRepository;
import com.example.todolistapi.dto.PostListDto;
import com.example.todolistapi.dto.PostSaveDto;
import com.example.todolistapi.dto.PostUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor //생성자 알아서 생성
@Service //PostSaveDto의 toEntity함수를 Repository를 통해 h2데이터베이스에 접근하도록 시키자.
public class PostService {
    private final PostsRepository postsRepository;

//    public PostService(PostsRepository postsRepository){
//        this.postsRepository = postsRepository;
//    }
    @Transactional //트랜잭션 발동!
    public Long save(PostSaveDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getNo();
    }

    @Transactional
    public Long update(Long No, PostUpdateDto postUpdateDto){
        Posts posts = postsRepository.findById(No).orElseThrow(() -> new IllegalArgumentException("해당하는 게시글이 없다. No : " + No));
        posts.update(postUpdateDto.getTitle(),postUpdateDto.getWhatToDo(), postUpdateDto.getWhenToDo(), postUpdateDto.getHowLongToDo() );
        return No;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<PostListDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(PostListDto::new).collect(Collectors.toList());
    }




    public PostListDto findByNo(Long No){
        Posts entity = postsRepository.findById(No).orElseThrow(() -> new IllegalArgumentException("해당하는 게시글이 없습니다. No : " + No));

        return new PostListDto(entity);
    }





}
