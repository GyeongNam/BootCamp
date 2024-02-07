package com.encore.OrderService.domain.order.controller;

import com.encore.OrderService.common.CommonResponse;
import com.encore.OrderService.domain.order.reqdto.OrderingReqCreateDTO;
import com.encore.OrderService.domain.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api")
public class OrderController {
    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/order/new")
    public ResponseEntity<CommonResponse> orderCreate(@RequestBody OrderingReqCreateDTO orderingReqCreateDTO){
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
