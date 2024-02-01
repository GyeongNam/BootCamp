package com.encore.OrderService.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
public class ResponseDTO  {
    private HttpStatus httpStatus;
    private String message;
    private Object result;

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
