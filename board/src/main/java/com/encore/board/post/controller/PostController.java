package com.encore.board.post.controller;

import com.encore.board.post.dto.PostCreateDto;
import com.encore.board.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String postCreate(PostCreateDto postCreateDto){
        postService.save(postCreateDto);
        return "redirect:/post/list";
    }

    @GetMapping("/post/list")
    public String postList(Model model){
        model.addAttribute("postList", postService.findAll());
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