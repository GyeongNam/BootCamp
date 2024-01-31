package com.encore.OrderService.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ResponseDTO  {
    private HttpStatus httpStatus;
    private  String message;
    private  Object dataID;
}
