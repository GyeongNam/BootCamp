package com.encore.Spring_basic.controller;

import com.encore.Spring_basic.domain.MemberRequestDTO;
import com.encore.Spring_basic.domain.MemberResponseDTO;
import com.encore.Spring_basic.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;

@Controller
@RestController
@RequestMapping("/rest")
public class MemberRestController {
    private final MemberService memberService;
    @Autowired
    public MemberRestController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping("/member/create")
    public String MemberAdd(@RequestBody MemberRequestDTO memberRequestDTO){
        memberService.save(memberRequestDTO);
        return "ok";
    }

    @GetMapping("/members")
    public List<MemberResponseDTO> getMembers() {
        return memberService.findAll();
    }

    @GetMapping("/member/find/{id}")
    public ResponseEntity<Map<String, Object>> getMemberDetail(@PathVariable long id){
        MemberResponseDTO memberResponseDTO = null;
        try{
            memberResponseDTO = memberService.findById(id);
            return ResponseEntityController.responseMassage(HttpStatus.OK,memberResponseDTO);
        }catch (Exception e){
            return ResponseEntityController.responseErrorMassage(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }

    @PatchMapping("/member/update")
    public MemberResponseDTO MemberUpdate(@RequestBody MemberRequestDTO memberRequestDTO){
        memberService.update(memberRequestDTO);
        return memberService.findById(memberRequestDTO.getId());
    }

    @DeleteMapping("/member/delete/{id}")
    public String getMemberDelete(@PathVariable long id){
        memberService.delete(id);
        return "ok";
    }
}
