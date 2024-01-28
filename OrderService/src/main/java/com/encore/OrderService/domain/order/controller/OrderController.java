package com.encore.OrderService.domain.order.controller;

import com.encore.OrderService.config.ResponseType;
import com.encore.OrderService.domain.order.reqdto.OrderingReqCreateDTO;
import com.encore.OrderService.domain.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
            return ResponseType.responseMassage(HttpStatus.CREATED, orderService.orderAdd(orderingReqCreateDTO));
        }catch (Exception e){
            return ResponseType.responseErrorMassage(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/orders")
    public ResponseEntity<Map<String, Object>> orderList(Pageable pageable){
        return ResponseType.responseMassage(HttpStatus.OK, orderService.orderingFindAll(pageable));
    }

    @PatchMapping("/order/{id}/cancel")
    public ResponseEntity<Map<String, Object>> orderCancel(@PathVariable Long id){
        try {
            return ResponseType.responseMassage(HttpStatus.OK, orderService.orderCancel(id));
        }catch (Exception e){
            return ResponseType.responseErrorMassage(HttpStatus.NOT_MODIFIED, e.getMessage());
        }
    }


}
