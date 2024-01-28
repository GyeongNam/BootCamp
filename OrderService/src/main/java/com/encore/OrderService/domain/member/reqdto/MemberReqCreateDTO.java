package com.encore.OrderService.domain.member.reqdto;


import com.encore.OrderService.domain.member.domain.Member;
import com.encore.OrderService.domain.member.domain.Role;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class MemberReqCreateDTO {
    private String name;
    private String email;
    private String password;
    private String address;
    private String role;

    public static Member MemberReqCreateDTOToMember(MemberReqCreateDTO memberReqCreateDTO){
        return Member.builder()
                .name(memberReqCreateDTO.getName())
                .email(memberReqCreateDTO.getEmail())
                .password(memberReqCreateDTO.getPassword())
                .address(memberReqCreateDTO.getAddress())
                .role(memberReqCreateDTO.getRole().equals("ADMIN") ? Role.ADMIN : Role.USER)
                .build();
    }
}
