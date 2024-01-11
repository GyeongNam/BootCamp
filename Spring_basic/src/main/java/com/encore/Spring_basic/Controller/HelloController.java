package com.encore.Spring_basic.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
 @RestController : 모든 요청에 @ResponseBody
 클래스 차원에서 url 경로를 지정하고 싶다면
 @RequestMapping을 클래스 위에 선언하면서 경로 지정

 */


@Controller
@RequestMapping("hello")
public class HelloController {
    /*
     @RequestBody 가 없고 return 타입이 String 이면 templates의 html 파일 return
     data 만을 return 할때는 @ResponseBody를 붙인다.
     @
     */
    @GetMapping("String")
    @ResponseBody
    public String helloString(){
        return "hello_String";
    }

    @GetMapping("screen")
    public String helloScreen(){
        return "screen";
    }

    @GetMapping("screen-model")
    public String helloScreenModel1(Model model){
        /*
        화면에 data 를 넘기고 싶을 때 model 객체를 사용
        모델에 key:value 형식으로 전달
         */
        model.addAttribute("data", "한희준");
        return "screen";
    }

    @GetMapping("screen-model-RequestParam")
    @ResponseBody
    public String helloScreenModel2(@RequestParam(value = "name") String inputName, Model model){

        model.addAttribute("data", inputName);
        return "screen";
    }
    /*
    @PathVariable 방식은 url를 통해 자원의 구조를 명확하게
    표현할 수 있어, 좀더 RestFul API에 적합.
     */
    @GetMapping("screen-model-PathVariable/{name}")
    public String helloScreenModel3(@PathVariable String name, Model model){

        model.addAttribute("data", name);
        return "screen";
    }

}
