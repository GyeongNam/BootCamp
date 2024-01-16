package com.encore.Spring_basic.controller;

import com.encore.Spring_basic.domain.MemberRequestDTO;
import com.encore.Spring_basic.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

/*
서비스 어노테이션을 통해 싱글톤 컴포넌트로 생성
-> 스프링 빈으로 등록

스프링 빈이란 스프링이 생성하고 관리하는 객체를 의미
제어의 역전 (Inversion of Control)
-> IOC컨테이너가 스프링빈을 관리(번들 생성, 의존성 주입)
 */
@Controller
public class MemberController {

    /*
    // 의존성 주임(DI) 방법 1 : 필드 주입방식
    @Autowired
    private MemberService memberService;
    */


    /*
    // 의존성 주임(DI) 방법 2 : 생성자 주입방식 (많이 사용)
    final을 통해 상수로 사용가능, 다형성 구현 가능, 순환참조방지
     */
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    /*
    // 의존성 주임(DI) 방법 3 : @RequiredArgsConstructor
    @NonNull 어노테이션이 붙어있는 필드 또는 최가화가 되어 있지 않은
    final 필드 대상으로 생성자 생성.
    private final MemberService memberService;
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    */

    @GetMapping("/")
    public String home(){
        return "member/header";
    }

    @GetMapping("/members")
    public String getMembers(Model model) {
        model.addAttribute( "memberList", memberService.findAll());
        return "member/member-list";
    }

    @GetMapping("/member/create")
    public String getMemberRegister(){
        return "member/member-create";
    }

    @PostMapping("/member/create")
    public String MemberAdd(MemberRequestDTO memberRequestDTO, Model model){
        memberService.save(memberRequestDTO);
        model.addAttribute( "memberList", memberService.findAll());
        return "redirect:/members";
    }

    @GetMapping("/member/find")
    public String getMemberDetail(@RequestParam long id, Model model){
        try{
            model.addAttribute( "member", memberService.findById(id));
            return "member/member-detail";
        }catch (NoSuchElementException e){
            return "404-error-page";
        }

    }
}
