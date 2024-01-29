package com.encore.board.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

/*
ControllerAdvice 와 ExceptionHandler 를 통해 예외처리의 공통화 로직 작성
 */
@Slf4j
@ControllerAdvice
public class CommonException {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, Object>> entityNotFoundExceptionHandler(EntityNotFoundException e){
        log.error("EntityNotFoundException message : " + e.getMessage());
        return this.responseErrorMassage(HttpStatus.NOT_FOUND,e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> IllegalArgumentExceptionHandler(IllegalArgumentException e){
        log.error("IllegalArgumentException : " + e.getMessage());
        return this.responseErrorMassage(HttpStatus.BAD_REQUEST,e.getMessage());
    }

    private ResponseEntity<Map<String, Object>> responseMassage(HttpStatus status, Object object){
        Map<String, Object> map = new HashMap<>();
        map.put("status", Integer.toString(status.value()));
        map.put("message", object);
        return new ResponseEntity<>(map, status);
    }

    private ResponseEntity<Map<String, Object>> responseErrorMassage(HttpStatus status, String message){
        Map<String, Object> map = new HashMap<>();
        map.put("status", Integer.toString(status.value()));
        map.put("status message", status.getReasonPhrase());
        map.put("error message", message);
        return new ResponseEntity<>(map, status);
    }
}
