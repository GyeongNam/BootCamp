package com.encore.Spring_basic.controller;

import com.encore.Spring_basic.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {
    @GetMapping("/members")
    public String getMembers(){
        return "member/memberList";
    }

    @GetMapping("/member/create-screen")
    public String getMemberRegister(){
        return "member/member-create";
    }

    @PostMapping("/member/create")
    @ResponseBody
    public String MemberAdd(Member member){
        System.out.println("회원가입 완료");
        System.out.println(member);
        System.out.println();
        return "회원가입완료";
    }
}
