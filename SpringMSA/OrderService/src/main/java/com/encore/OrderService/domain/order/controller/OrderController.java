package com.encore.OrderService.domain.order.controller;

import com.encore.OrderService.common.CommonResponse;
import com.encore.OrderService.domain.member.service.MemberService;
import com.encore.OrderService.domain.order.reqdto.OrderingReqCreateDTO;
import com.encore.OrderService.domain.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RestController
@RequestMapping("/api")
public class OrderController {
    private final OrderService orderService;
    private final MemberService memberService;
    @Autowired
    public OrderController(
            OrderService orderService,
            MemberService memberService
    ){
        this.orderService = orderService;
        this.memberService = memberService;
    }

    @PostMapping("/order/new")
    public ResponseEntity<CommonResponse> orderCreate(@AuthenticationPrincipal UserDetails userDetails, @RequestBody  OrderingReqCreateDTO orderingReqCreateDTO){
        orderingReqCreateDTO.setMember_id(memberService.findByEmail(userDetails.getUsername()).getId());
        return CommonResponse.responseMassage(HttpStatus.CREATED, orderService.orderAdd(orderingReqCreateDTO));
    }

    @GetMapping("/orders")
    public ResponseEntity<CommonResponse> orderList(Pageable pageable){
        return CommonResponse.responseMassage(HttpStatus.OK, orderService.orderingFindAll(pageable));
    }

    @PatchMapping("/order/{id}/cancel")
    public ResponseEntity<CommonResponse> orderCancel(@PathVariable Long id, Pageable pageable){
        orderService.orderCancel(id);
        return CommonResponse.responseMassage(HttpStatus.OK, orderService.orderingFindAll(pageable));
    }

    @GetMapping("/order-items/{id}")
    public ResponseEntity<CommonResponse> orderItemList(@PathVariable Long id, Pageable pageable){
        return CommonResponse.responseMassage(HttpStatus.OK, orderService.orderItemList(id, pageable));
    }


}
