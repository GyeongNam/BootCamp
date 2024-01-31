package com.encore.OrderService.domain.member.controller;

import com.encore.OrderService.common.ExceptionHandlerClass;
import com.encore.OrderService.common.ResponseDTO;
import com.encore.OrderService.domain.member.reqdto.MemberReqCreateDTO;
import com.encore.OrderService.domain.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/member/create")
    public ResponseEntity<ResponseDTO> memberRegister(@RequestBody MemberReqCreateDTO memberReqCreateDTO){
        return ExceptionHandlerClass.responseMassage(HttpStatus.CREATED, memberService.register(memberReqCreateDTO));
    }

    @GetMapping("/members")
    public ResponseEntity<ResponseDTO> members(Pageable pageable){
        return ExceptionHandlerClass.responseMassage(HttpStatus.OK, memberService.memberList(pageable));
    }

    @GetMapping("/member/{id}/orders")
    public ResponseEntity<ResponseDTO> memberOrders(@PathVariable Long id, Pageable pageable){
        return ExceptionHandlerClass.responseMassage(HttpStatus.OK, memberService.memberOrderList(pageable, id));
    }
}
