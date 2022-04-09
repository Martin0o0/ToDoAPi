package com.example.todolistwar.Controller;


import com.example.todolistwar.PostRepository.Posts;
import com.example.todolistwar.Service.PostService;
import com.example.todolistwar.dto.PostListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class PageController {
    private final PostService postService;

//    @RequestMapping("/main")
//    public String hello(){
//        return "hello.html";
//    }

    @RequestMapping("/")
    public String main(){
        return "mainpost";
    }

    @GetMapping("/todolist")
    public String ToDoList(Model model, @PageableDefault(sort="whenToDo", direction = Sort.Direction.ASC) Pageable pageable) {
        //머스테치에 객체를 보내주기 위해 가인수로 받자., PageableDefault로  No값으로 정렬 받고, direction으로 오름차순 정렬
        Page<Posts> list = postService.pageList(pageable);

        model.addAttribute("posts", list);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber()); //이전페이지 번호를 받아오고
        model.addAttribute("next", pageable.next().getPageNumber()); //다음 페이지 번호를 받아온다.
        model.addAttribute("hasNext", list.hasNext());
        model.addAttribute("hasPrev", list.hasPrevious());

        System.out.println(list.hasNext());
        System.out.println(list.hasPrevious());

        return "TodoList";
    }


    @GetMapping("/todolist/search")
    public String ToDoListSearch(String key, Model model, @PageableDefault(sort="whenToDo", direction = Sort.Direction.ASC) Pageable pageable) {
        log.info(key);
        //머스테치에 객체를 보내주기 위해 가인수로 받자., PageableDefault로  No값으로 정렬 받고, direction으로 오름차순 정렬
        Page<Posts> list = postService.search(key, pageable);

        model.addAttribute("posts", list);
        model.addAttribute("key", key);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber()); //이전페이지 번호를 받아오고
        model.addAttribute("next", pageable.next().getPageNumber()); //다음 페이지 번호를 받아온다.
        model.addAttribute("hasNext", list.hasNext());
        model.addAttribute("hasPrev", list.hasPrevious());
        System.out.println(list.hasNext());
        System.out.println(list.hasPrevious());

        return "TodoListSearch";
    }


    @GetMapping("/todolist/complete")
    public String ToDoListComplete(Model model, @PageableDefault(sort="whenToDo", direction = Sort.Direction.ASC) Pageable pageable) {
        //머스테치에 객체를 보내주기 위해 가인수로 받자., PageableDefault로  No값으로 정렬 받고, direction으로 오름차순 정렬
        Page<Posts> list = postService.isComplete(true, pageable);

        model.addAttribute("posts", list);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber()); //이전페이지 번호를 받아오고
        model.addAttribute("next", pageable.next().getPageNumber()); //다음 페이지 번호를 받아온다.
        model.addAttribute("hasNext", list.hasNext());
        model.addAttribute("hasPrev", list.hasPrevious());
        log.info(Integer.toString(pageable.next().getPageNumber()));
        log.info(Integer.toString(pageable.next().getPageNumber()));
        System.out.println(list.hasNext());
        System.out.println(list.hasPrevious());

        return "TodoListComplete";
    }
    @GetMapping("/todolist/not-complete")
    public String ToDoListNotComplete(Model model, @PageableDefault(sort="whenToDo", direction = Sort.Direction.ASC) Pageable pageable) {
        //머스테치에 객체를 보내주기 위해 가인수로 받자., PageableDefault로  No값으로 정렬 받고, direction으로 오름차순 정렬
        Page<Posts> list = postService.isComplete(false, pageable);

        model.addAttribute("posts", list);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber()); //이전페이지 번호를 받아오고
        model.addAttribute("next", pageable.next().getPageNumber()); //다음 페이지 번호를 받아온다.
        model.addAttribute("hasNext", list.hasNext());
        model.addAttribute("hasPrev", list.hasPrevious());
        log.info(Integer.toString(pageable.next().getPageNumber()));
        log.info(Integer.toString(pageable.next().getPageNumber()));
        System.out.println(list.hasNext());
        System.out.println(list.hasPrevious());

        return "TodoListNotComplete";
    }


    /*
    @PageableDefault

      ○ size : 한 페이지에 담을 모델의 수를 정할 수 있다. 기본 값은 10이다.

      ○ sort : 정렬의 기준이 되는 속성을 정한다.

      ○ direction : 오름차순과 내림차순 중 기준을 선택할 수 있다.

      ○ Pageable pageable : PageableDefault 값을 갖고 있는 변수를 선언한다.

출처: https://dev-coco.tistory.com/114?category=1032063 [슬기로운 개발생활😃]
     */

//    @GetMapping("/api/get/{No}")
//    public String update(@PathVariable Long No, Model model) {
//        PostListDto Dto = postService.findByNo(No);
//        model.addAttribute("posts", Dto);
//
//        return "testput";
//    }



}
