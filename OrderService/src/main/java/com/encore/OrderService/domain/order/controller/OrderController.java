package com.encore.OrderService.domain.order.controller;

import com.encore.OrderService.config.ResponseType;
import com.encore.OrderService.domain.order.reqdto.OrderingReqCreateDTO;
import com.encore.OrderService.domain.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
    public ResponseEntity<Map<String, Object>> orderCreate(@RequestBody OrderingReqCreateDTO orderingReqCreateDTO){
        try {
            System.out.println(orderingReqCreateDTO);
            return ResponseType.responseMassage(HttpStatus.CREATED, orderService.orderAdd(orderingReqCreateDTO));
        }catch (Exception e){
            return ResponseType.responseErrorMassage(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}
