package com.encore.OrderService.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
public class CommonResponse {
    private HttpStatus httpStatus;
    private String message;
    private Object result;

    public static ResponseEntity<CommonResponse> responseMassage(HttpStatus status, Object object){
        return new ResponseEntity<>(
                new CommonResponse(status , "성공", object),
                status
        );
    }

    public static ResponseEntity<CommonResponse> responseErrorMassage(HttpStatus status, String message){
        return new ResponseEntity<>(
                new CommonResponse(status , "실패", message),
                status
        );
    }
}
