package com.example.todolistapi.Service;


import com.example.todolistapi.PostRepository.Posts;
import com.example.todolistapi.PostRepository.PostsRepository;
import com.example.todolistapi.dto.PostListDto;
import com.example.todolistapi.dto.PostSaveDto;
import com.example.todolistapi.dto.PostUpdateDto;
import com.example.todolistapi.dto.PostUpdateIsCompleteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public Long update(Long No, PostUpdateDto postupdateDto){
        Posts posts = postsRepository.findById(No).orElseThrow(() -> new IllegalArgumentException("해당하는 게시글이 없다. No : " + No));
        posts.update(postupdateDto.getTitle(),postupdateDto.getWhatToDo(), postupdateDto.getWhenToDo(), postupdateDto.getHowLongToDo() );
        return No;
    }

    @Transactional
    public Long updateComplete(Long No, PostUpdateIsCompleteDto postUpdateIsCompleteDto){
        Posts posts = postsRepository.findById(No).orElseThrow(() -> new IllegalArgumentException("해당하는 게시글이 없다. "));
        posts.updateComplete(postUpdateIsCompleteDto.getIsComplete());
        return No;
    }

    //순수 읽기 전용으로 stream에서 map을 람다식으로 해서 toList로 변환 후, 머스타치로 보내주자!
//    @org.springframework.transaction.annotation.Transactional(readOnly = true)
//    public List<PostListDto> findAllDesc(){
//        return postsRepository.findAllDesc().stream().map(dto -> new PostListDto(dto)).collect(Collectors.toList());
//    }

    //페이징 처리 10개로 제한.
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Page<Posts> pageList(Pageable pageable){ //page<T>로 지정하면 바드시 파라미터로 pageable한것으로 해주어야 한다고 함.
        return postsRepository.findAll(pageable);
    }

    @Transactional
    public Page<Posts> search(String key, Pageable pageable){
        Page<Posts> list = postsRepository.findByTitleContaining(key, pageable);
        return list;
    }

    @Transactional
    public Long delete(Long No){
        Posts posts = postsRepository.findById(No).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없다. 삭제할 수 없음."));
        postsRepository.delete(posts);
        return No;
    }




    @Transactional
    public PostListDto findByNo(Long No){
        Posts entity = postsRepository.findById(No).orElseThrow(() -> new IllegalArgumentException("해당하는 게시글이 없습니다. No : " + No));

        return new PostListDto(entity);
    }





}
