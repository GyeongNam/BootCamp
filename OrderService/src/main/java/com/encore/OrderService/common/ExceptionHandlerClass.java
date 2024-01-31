package com.encore.OrderService.common.config;

import com.encore.OrderService.common.ResponseDTO;
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
    public ResponseEntity<ResponseDTO> AllExceptionHandler(Exception e){

        log.error(e.getClass().getName() + " : " + e.getMessage());

        if(e instanceof EntityNotFoundException){
            return responseErrorMassage(HttpStatus.NOT_FOUND, e.getMessage());
        }

        if(e instanceof IllegalArgumentException){
            return responseErrorMassage(HttpStatus.BAD_REQUEST, e.getMessage());
        }

        if(e instanceof DataIntegrityViolationException){
            return responseErrorMassage(HttpStatus.CONFLICT, e.getMessage());
        }

        return responseErrorMassage(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    public static ResponseEntity<ResponseDTO> responseMassage(HttpStatus status, Object object){
        return new ResponseEntity<>(
                new ResponseDTO(status , "성공", object),
                status
        );
    }

    public static ResponseEntity<ResponseDTO> responseErrorMassage(HttpStatus status, String message){
        return new ResponseEntity<>(
                new ResponseDTO(status , "실패", message),
                status
        );
    }
}
