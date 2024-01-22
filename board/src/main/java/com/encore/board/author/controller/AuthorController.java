package com.encore.board.author.controller;

import com.encore.board.author.dto.AuthorSaveDto;
import com.encore.board.author.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthorController {

    private final AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }


    @GetMapping("/")
    public String home(){
        return "/home";
    }

    @PostMapping("/author/save")
    @ResponseBody
    public String authorSave(AuthorSaveDto authorSaveDto){
        authorService.save(authorSaveDto);
        return "ok";
    }

    @GetMapping("/author/list")
    public String authorList(Model model){
        model.addAttribute("authorList", authorService.findAll());
        return "/author/author-list";
    }

    @GetMapping("/author/detail/{id}")
    public String authorDetail(@PathVariable long id, Model model)  {
        try {
            model.addAttribute("author",authorService.findById(id));
            return "/author/author-detail";
        }catch (Exception e){
            return "redirect:/author/list";
        }

    }
}
