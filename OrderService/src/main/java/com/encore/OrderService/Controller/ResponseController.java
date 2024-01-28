package com.encore.OrderService.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ResponseController {
    public static ResponseEntity<Map<String, Object>> responseMassage(HttpStatus status, Object object){
        Map<String, Object> map = new HashMap<>();
        map.put("status", Integer.toString(status.value()));
        map.put("message", object);
        return new ResponseEntity<>(map, status);
    }

    public static ResponseEntity<Map<String, Object>> responseErrorMassage(HttpStatus status, String message){
        Map<String, Object> map = new HashMap<>();
        map.put("status", Integer.toString(status.value()));
        map.put("status message", status.getReasonPhrase());
        map.put("error message", message);
        return new ResponseEntity<>(map, status);
    }
}
