package com.encore.OrderService.domain.member.resdto;

import com.encore.OrderService.domain.member.domain.Member;
import com.encore.OrderService.domain.member.domain.Role;
import com.encore.OrderService.domain.ordering.domain.Ordering;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MemberResDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String role;
    private List<Ordering> orderings;
    private String createdTime;
    private String updatedTime;

    public static Member MemberResMemberDTOToMember(MemberResDTO memberResDTO){
        return Member.builder()
                .id(memberResDTO.getId())
                .name(memberResDTO.getName())
                .email(memberResDTO.getEmail())
                .password(memberResDTO.getPassword())
                .address(memberResDTO.getAddress())
                .orderings(memberResDTO.getOrderings())
                .role(memberResDTO.getRole().equals("ADMIN") ? Role.ADMIN : Role.USER)
                .build();
    }
}
