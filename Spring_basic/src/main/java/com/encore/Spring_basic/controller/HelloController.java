package com.encore.Spring_basic.controller;

import com.encore.Spring_basic.domain.Hello;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/*
 @RestController : 모든 요청에 @ResponseBody
 클래스 차원에서 url 경로를 지정하고 싶다면
 @RequestMapping을 클래스 위에 선언하면서 경로 지정

 */


@Controller
@RequestMapping("/hello")
public class HelloController {
    /*
     @RequestBody 가 없고 return 타입이 String 이면 templates의 html 파일 return
     data 만을 return 할때는 @ResponseBody를 붙인다.
     @
     */
    @GetMapping("/String")
    @ResponseBody
    public String helloString(){
        return "hello_String";
    }

    @GetMapping("/screen")
    public String helloScreen(){
        return "screen";
    }

    @GetMapping("/screen-model")
    public String helloScreenModel1(Model model){
        /*
        화면에 data 를 넘기고 싶을 때 model 객체를 사용
        모델에 key:value 형식으로 전달
         */
        model.addAttribute("data", "한희준");
        return "screen";
    }

    @GetMapping("/screen-model-RequestParam")
    @ResponseBody
    public String helloScreenModel2(@RequestParam(value = "name") String inputName, Model model){

        model.addAttribute("data", inputName);
        return "screen";
    }
    /*
    @PathVariable 방식은 url를 통해 자원의 구조를 명확하게
    표현할 수 있어, 좀더 RestFul API에 적합.
     */
    @GetMapping("/screen-model-PathVariable/{name}")
    public String helloScreenModel3(@PathVariable String name, Model model){

        model.addAttribute("data", name);
        return "screen";
    }

    @GetMapping("/json")
    @ResponseBody
    public Hello hellojson(){
        Hello hello = new Hello();
        hello.setName("한희준");
        hello.setEmail("abc");
        hello.setPassword("1234");
        System.out.println(hello.toString());
        return hello;
    }


    // 화면 보여주기
    @GetMapping("/form-screen")
    public String form_screen(){
        return "hello-form-screen";
    }

    // form 데이터 처리
    @PostMapping("/form-screen-handle")
    @ResponseBody
    public Hello form_screen_handle(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password

    ){
        Hello hello = new Hello();
        hello.setName(name);
        hello.setEmail(email);
        hello.setPassword(password);
        return hello;
    }

    @PostMapping("/form-screen-handle1")
    @ResponseBody
    public Hello form_screen_handle1(Hello hello){
        System.out.println(hello);
        return hello;
    }

    // json 데이터 처리

    @GetMapping("/json-screen")
    public String json_screen(){
        return "hello-json-screen";
    }

    // post로 요청이 들어왔을때 body에서 data를 꺼내기 위해 사용
    @PostMapping("/json-screen-handle1")
    @ResponseBody
    public Map<String,String> json_screen_handle1(
            @RequestBody Map<String, String> body
    ){
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("req_name", body.get("name"));
        reqMap.put("req_email", body.get("email"));
        reqMap.put("req_password", body.get("password"));
        reqMap.put("url", "/hello/json-screen");
        System.out.println("json_screen_handle1");
        System.out.println(reqMap);
        System.out.println();
        return reqMap;
    }
    @PostMapping("/json-screen-handle2")
    @ResponseBody
    public String json_screen_handle2(@RequestBody JsonNode body){

        Hello hello = new Hello();
        hello.setName(body.get("name").asText());
        hello.setEmail(body.get("email").asText());
        hello.setPassword(body.get("password").asText());

        System.out.println("json_screen_handle2");
        System.out.println("이름 : "+ hello.getName());
        System.out.println("이메일 : "+ hello.getEmail());
        System.out.println("비밀번호 : "+ hello.getPassword());

        System.out.println();
        return "ok";
    }
    @PostMapping("/json-screen-handle3")
    @ResponseBody
    public String json_screen_handle3(@RequestBody Hello hello){
        System.out.println("json_screen_handle3");
        System.out.println(hello);
        System.out.println();
        return  "ok";
    }
}
