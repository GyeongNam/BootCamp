package com.encore.OrderService.domain.member.reqdto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginReqDTO {
    @NotEmpty(message = "email is essential")
    @Email(message = "email is not valid")
    private String email;

    @NotEmpty(message = "password is essential")
    @Size(min = 4 , message = "minimum length is 4")
    private String password;

}
