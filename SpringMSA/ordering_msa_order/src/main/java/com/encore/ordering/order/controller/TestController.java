package com.encore.ordering.order.controller;


import com.encore.ordering.order.dto.MemberDto;
import com.encore.ordering.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class TestController {
    private final String MEMBER_API = "http://member-service/";

    private final RestTemplate restTemplate;

    private final OrderService orderService;

    public TestController(
            RestTemplate restTemplate,
            OrderService orderService
    ) {
        this.restTemplate = restTemplate;
        this.orderService = orderService;
    }

    @GetMapping("/test/restTemplate")
    public void restTemplate(){
        String url = MEMBER_API + "member/1";
        MemberDto memberDto = restTemplate.getForObject(url, MemberDto.class);
        log.info(memberDto.toString());

    }


}
