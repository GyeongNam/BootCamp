package com.encore.board.author.controller;

import com.encore.board.author.domain.Author;
import com.encore.board.author.dto.AuthorDetailResDto;
import com.encore.board.author.dto.AuthorSaveDto;
import com.encore.board.author.dto.AuthorUpdateDto;
import com.encore.board.author.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

@Slf4j
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

    @PostMapping("/author/create")
    public String authorSave(AuthorSaveDto authorSaveDto, Model model, HttpServletRequest request){
        try {
            authorService.save(authorSaveDto);
            return "redirect:/author/list";
        }catch (IllegalArgumentException e){
            model.addAttribute("errorMessage", e.getMessage());
//            return "redirect:"+request.getHeader("Referer");
            log.error(e.getMessage());
            return "/author/author-create";
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
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
            log.error(e.getMessage());
            return "redirect:/author/list";
        }
    }

    @PostMapping("/author/update/{id}")
    private String authorUpdate(@PathVariable long id, AuthorUpdateDto authorUpdateDto){
        try {
            authorUpdateDto.setId(id);
            Author author = authorService.update(authorUpdateDto);
            return "redirect:/author/detail/"+author.getId();
        }catch (EntityNotFoundException e){
            log.error(e.getMessage());
            return "redirect:/author/list";
        }
    }

    @GetMapping("/author/delete/{id}")
    private String authorDelete( @PathVariable long id){
        authorService.delete(id);
        return "redirect:/author/list";
    }

    /*
    연관관계가 있는 Author 엔티티를 json 으로 직렬화를 하게 될 경우 순환 참조 이슈 발생하므로, DTO 사용 필요.
     */
    @GetMapping("/author/{id}/circle/issue")
    @ResponseBody
    public Author circleIssueTest(@PathVariable Long id){
        return authorService.findById(id);
    }

    @GetMapping("/author/{id}/circle/dto")
    @ResponseBody
    public AuthorDetailResDto circleIssueTest2(@PathVariable Long id){
        return authorService.findAuthorDetail(id);
    }

    /*
    로그인 페이지
     */

    @GetMapping("/author/login-page")
    public String loginPage(){
        return "/author/author-login";
    }

    @PostMapping("/")
    public String loging(){
        return "/author/author-login";
    }
}
