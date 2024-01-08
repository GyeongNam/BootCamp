package com.example.demo.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class PostController {
    private PostService postService;

    public PostController() {
        this.postService = new PostService();
    }

    @GetMapping("/csr/json")
    @ResponseBody
    public List<Post> findAllcsr(){
        return postService.findAll();
    }

    // 사용자에게 (화면 + data) return
    @GetMapping("/ssr")
    public String findAllssr(Model model){
        List<Post> posts = postService.findAll();
        model.addAttribute("postList", posts);
        return "post_list";
    }

}
