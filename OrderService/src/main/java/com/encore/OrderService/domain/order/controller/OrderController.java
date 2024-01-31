package com.encore.OrderService.domain.order.controller;

import com.encore.OrderService.common.ExceptionHandlerClass;
import com.encore.OrderService.common.ResponseDTO;
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
    public ResponseEntity<ResponseDTO> orderCreate(@RequestBody OrderingReqCreateDTO orderingReqCreateDTO){
        return ExceptionHandlerClass.responseMassage(HttpStatus.CREATED, orderService.orderAdd(orderingReqCreateDTO));
    }

    @GetMapping("/orders")
    public ResponseEntity<ResponseDTO> orderList(Pageable pageable){
        return ExceptionHandlerClass.responseMassage(HttpStatus.OK, orderService.orderingFindAll(pageable));
    }

    @PatchMapping("/order/{id}/cancel")
    public ResponseEntity<ResponseDTO> orderCancel(@PathVariable Long id){
        return ExceptionHandlerClass.responseMassage(HttpStatus.OK, orderService.orderCancel(id));
    }

    @GetMapping("/order-items/{id}")
    public ResponseEntity<ResponseDTO> orderItemList(@PathVariable Long id, Pageable pageable){
        return ExceptionHandlerClass.responseMassage(HttpStatus.OK, orderService.orderItemList(id, pageable));
    }


}
