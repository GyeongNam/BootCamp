package com.encore.OrderService.domain.member.reqdto;


import com.encore.OrderService.domain.member.domain.Address;
import com.encore.OrderService.domain.member.domain.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberReqCreateDTO {
    @NotEmpty(message = "name is essential")
    private String name;

    @NotEmpty(message = "email is essential")
    @Email(message = "email is not valid")
    private String email;

    @NotEmpty(message = "password is essential")
    @Size(min = 4 , message = "minimum length is 4")
    private String password;

    private String city;
    private String street;
    private String zipcode;

    public static Member MemberReqCreateDTOToMember(MemberReqCreateDTO memberReqCreateDTO, PasswordEncoder passwordEncoder){
        return Member.builder()
                .name(memberReqCreateDTO.getName())
                .email(memberReqCreateDTO.getEmail())
                .password(passwordEncoder.encode(memberReqCreateDTO.getPassword()))
                .address(Address.builder()
                        .city(memberReqCreateDTO.getCity())
                        .street(memberReqCreateDTO.getStreet())
                        .zipcode(memberReqCreateDTO.getZipcode())
                        .build())
                .build();
    }
}
