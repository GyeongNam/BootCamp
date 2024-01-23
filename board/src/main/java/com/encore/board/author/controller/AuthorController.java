package com.encore.board.author.controller;

import com.encore.board.author.dto.AuthorSaveDto;
import com.encore.board.author.dto.AuthorUpdateDto;
import com.encore.board.author.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityNotFoundException;

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

    @GetMapping("/author/create")
    public String authorCreate(){
        return "/author/author-create";
    }

    @PostMapping("/author/save")
    public String authorSave(AuthorSaveDto authorSaveDto){
        authorService.save(authorSaveDto);
        return "redirect:/author/list";
    }

    @GetMapping("/author/list")
    public String authorList(Model model){
        model.addAttribute("authorList", authorService.findAll());
        return "/author/author-list";
    }

    @GetMapping("/author/detail/{id}")
    public String authorDetail(@PathVariable long id, Model model)  {
        try {
            model.addAttribute("author",authorService.findAuthorDetail(id));
            return "/author/author-detail";
        }catch (EntityNotFoundException e){
            return "redirect:/author/list";
        }
    }

    @PostMapping("/author/update/{id}")
    private String authorUpdate(@PathVariable long id, AuthorUpdateDto authorUpdateDto){
        try {
            authorUpdateDto.setId(id);
            authorService.update(authorUpdateDto);
            return "redirect:/author/detail/"+authorUpdateDto.getId();
        }catch (EntityNotFoundException e){
            return "redirect:/author/list";
        }
    }

    @GetMapping("/author/delete/{id}")
    private String authorDelete( @PathVariable long id){
        authorService.delete(id);
        return "redirect:/author/list";

    }
}
