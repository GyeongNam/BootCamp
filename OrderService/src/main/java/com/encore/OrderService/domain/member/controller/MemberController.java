package com.encore.OrderService.domain.member.controller;

import com.encore.OrderService.Controller.ResponseController;
import com.encore.OrderService.domain.member.reqdto.MemberReqCreateDTO;
import com.encore.OrderService.domain.member.service.MemberService;
import org.hibernate.annotations.Fetch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.Map;

@Controller
@RestController
@RequestMapping("/api")
public class MemberController {
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping("/member/new")
    public ResponseEntity<Map<String, Object>> MemberRegister(MemberReqCreateDTO memberReqCreateDTO){
        try{
            return ResponseController.responseMassage(HttpStatus.CREATED,memberService.register(memberReqCreateDTO));
        }catch (Exception e){
            return ResponseController.responseErrorMassage(HttpStatus.CONFLICT, e.getMessage());
        }
    }
}
