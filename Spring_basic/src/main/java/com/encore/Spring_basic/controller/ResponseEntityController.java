package com.encore.Spring_basic.controller;

import com.encore.Spring_basic.domain.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/response/entity")
public class ResponseEntityController {
    @GetMapping("response-status")
    @ResponseStatus(HttpStatus.CREATED)
    public String responseStatus(){
        return "ok";
    }

    @ResponseStatus(HttpStatus.CREATED)
    public Member responseStatus2(){
        Member member = new Member("김선국","구기구기","그야 말로 신이야");
        return member;
    }

    // ResponseEntity 를 직접 생성하는 방법
    public ResponseEntity<Member> responseStatus3(){
        Member member = new Member("김선국","구기구기","그야 말로 신이야");
        return new ResponseEntity<>(member,HttpStatus.CREATED);
    }

    // ResponseEntity<String> 일 경우 text/html 로 설정
    public ResponseEntity<String> responseStatus4(){
        String html = "<h1>없는 ID입니다.</h1>";
        return new ResponseEntity<>(html,HttpStatus.NOT_FOUND);
    }

    // map 형태의 메시지 커스텀
    public static ResponseEntity<Map<String, Object>> responseErrorMassage(HttpStatus status, String message){
        Map<String, Object> map = new HashMap<>();
        map.put("status", Integer.toString(status.value()));
        map.put("status message", status.getReasonPhrase());
        map.put("error message", message);
        return new ResponseEntity<>(map, status);
    }

    public static ResponseEntity<Map<String, Object>> responseMassage(HttpStatus status, Object object){
        Map<String, Object> map = new HashMap<>();
        map.put("status", Integer.toString(status.value()));
        map.put("message", object);
        return new ResponseEntity<>(map, status);
    }

    /*
    메서드 채이닝 : ResponseEntity 의 클래스에서도 사용
     */
    @GetMapping("chaing1")
    public  ResponseEntity<Member> chaing1() {
        Member member = new Member("김선국","구기구기","그야 말로 신이야");
        return ResponseEntity.ok(member);
    }

    @GetMapping("chaing2")
    public  ResponseEntity<String> chaing2() {
        return ResponseEntity.notFound().build();
    }

    @GetMapping("chaing3")
    public ResponseEntity<Member> chaing3() {
        Member member = new Member("김선국","구기구기","그야 말로 신이야");
        return ResponseEntity.status(HttpStatus.CREATED).body(member);
    }
}
