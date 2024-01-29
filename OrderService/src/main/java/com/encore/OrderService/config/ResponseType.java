package com.encore.OrderService.config;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class ResponseType {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> AllExceptionHandler(Exception e){
        if(e instanceof EntityNotFoundException){
            log.error("EntityNotFoundException message : " + e.getMessage());
            return responseErrorMassage(HttpStatus.NOT_FOUND, e.getMessage());
        }

        if(e instanceof IllegalArgumentException){
            log.error("IllegalArgumentException message : " + e.getMessage());
            return responseErrorMassage(HttpStatus.BAD_REQUEST, e.getMessage());
        }

        if(e instanceof DataIntegrityViolationException){
            log.error("DataIntegrityViolationException message : " + e.getMessage());
            return responseErrorMassage(HttpStatus.CONFLICT, e.getMessage());
        }

        return responseErrorMassage(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

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
