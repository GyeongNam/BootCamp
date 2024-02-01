package com.encore.OrderService.domain.member.controller;

import com.encore.OrderService.common.JWTprovider;
import com.encore.OrderService.common.ResponseDTO;
import com.encore.OrderService.domain.member.domain.Member;
import com.encore.OrderService.domain.member.reqdto.LoginReqDTO;
import com.encore.OrderService.domain.member.reqdto.MemberReqCreateDTO;
import com.encore.OrderService.domain.member.resdto.MemberResDTO;
import com.encore.OrderService.domain.member.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
@RequestMapping("/api")
public class MemberController {
    private final MemberService memberService;
    private final JWTprovider jwTprovider;
    @Autowired
    public MemberController(
            MemberService memberService, JWTprovider jwTprovider
    ){
        this.memberService = memberService;
        this.jwTprovider = jwTprovider;
    }

    @PostMapping("/member/create")
    public ResponseEntity<ResponseDTO> memberRegister(@Valid @RequestBody MemberReqCreateDTO memberReqCreateDTO){
        return ResponseDTO.responseMassage(HttpStatus.CREATED, memberService.register(memberReqCreateDTO));
    }

    @GetMapping("/members")
    public ResponseEntity<ResponseDTO> members(Pageable pageable){
        return ResponseDTO.responseMassage(HttpStatus.OK, memberService.memberList(pageable));
    }

    @GetMapping("/member/{id}/orders")
    public ResponseEntity<ResponseDTO> memberOrders(@PathVariable Long id, Pageable pageable){
        return ResponseDTO.responseMassage(HttpStatus.OK, memberService.memberOrderList(pageable, id));
    }

    @PostMapping("/doLogin")
    public ResponseEntity<ResponseDTO> memberLogin(@Valid @RequestBody LoginReqDTO loginReqDTO){
        Member member = memberService.login(loginReqDTO);
        // 토큰 생성
        String jwt = jwTprovider.createToken(member.getEmail(), member.getRole().toString());

        Map<String, Object> map = new HashMap<>();
        map.put("id",member.getId());
        map.put("token", jwt);

        return ResponseDTO.responseMassage(HttpStatus.OK, map);
    }

    @GetMapping("/member/myInfo")
    public MemberResDTO myInfo(){
        return memberService.findByInfo();
    }
}
