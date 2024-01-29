package com.encore.OrderService.domain.member.controller;

import com.encore.OrderService.config.ResponseType;
import com.encore.OrderService.domain.member.domain.Member;
import com.encore.OrderService.domain.member.reqdto.MemberReqCreateDTO;
import com.encore.OrderService.domain.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RestController
@RequestMapping("/api")
public class MemberController {
    private final MemberService memberService;
    @Autowired
    public MemberController(
            MemberService memberService
    ){
        this.memberService = memberService;
    }

    @PostMapping("/member/new")
    public ResponseEntity<Map<String, Object>> memberRegister(MemberReqCreateDTO memberReqCreateDTO){
        return ResponseType.responseMassage(HttpStatus.CREATED, memberService.register(memberReqCreateDTO));
    }

    @GetMapping("/members")
    public ResponseEntity<Map<String, Object>> members(Pageable pageable){
        return ResponseType.responseMassage(HttpStatus.OK, memberService.memberList(pageable));
    }

    @GetMapping("/member/{id}/orders")
    public ResponseEntity<Map<String, Object>> memberOrders(@PathVariable Long id, Pageable pageable){
        return ResponseType.responseMassage(HttpStatus.OK, memberService.memberOrderList(pageable, id));
    }
}
