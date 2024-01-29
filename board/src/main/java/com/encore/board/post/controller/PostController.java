package com.encore.board.post.controller;

import com.encore.board.post.dto.PostCreateDto;
import com.encore.board.post.dto.PostListDto;
import com.encore.board.post.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class PostController {
    private final PostService postService;
    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/post/create")
    public String postCreatePage(){
        return "/post/post-create";
    }

    @PostMapping("/post/create")
    public String postCreate(PostCreateDto postCreateDto , Model model){
        try{
            postService.save(postCreateDto);
            return "redirect:/post/list";
        }catch (Exception e){
            model.addAttribute("errorMessage", e.getMessage());
            log.error(e.getMessage());
            return "/post/post-create";
        }


    }

    // /post/list/?size=xx&page=xx&sort=xx,desc
    @GetMapping("/post/list")
    public String pagePostList(Model model , @PageableDefault(size = 10, sort = "updatedTime", direction = Sort.Direction.DESC) Pageable pageable){
        Page<PostListDto> postListDtoList = postService.pageFindAll(pageable);
        model.addAttribute("postList", postListDtoList);
        return "/post/post-list";
    }

    @GetMapping("/post/detail/{id}")
    public String postDetail(@PathVariable long id, Model model){
        model.addAttribute("post", postService.findPostDetail(id));
        return "/post/post-detail";
    }

    @PostMapping("/post/update/{id}")
    private String authorUpdate(@PathVariable long id, PostCreateDto postCreateDto){
        postService.update(id,postCreateDto);
        return "redirect:/post/detail/"+id;
    }

    @GetMapping("/post/delete/{id}")
    private String authorDelete( @PathVariable long id){
        postService.delete(id);
        return "redirect:/post/list";
    }
}