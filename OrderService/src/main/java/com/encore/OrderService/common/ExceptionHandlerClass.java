package com.encore.OrderService.common;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerClass {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResponse> AllExceptionHandler(Exception e){

        log.error(e.getClass().getName() + " : " + e.getMessage());

        if(e instanceof EntityNotFoundException){
            return CommonResponse.responseErrorMassage(HttpStatus.NOT_FOUND, e.getMessage());
        }

        if(e instanceof IllegalArgumentException){
            return CommonResponse.responseErrorMassage(HttpStatus.BAD_REQUEST, e.getMessage());
        }

        if(e instanceof DataIntegrityViolationException){
            return CommonResponse.responseErrorMassage(HttpStatus.CONFLICT, e.getMessage());
        }

        return CommonResponse.responseErrorMassage(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}
