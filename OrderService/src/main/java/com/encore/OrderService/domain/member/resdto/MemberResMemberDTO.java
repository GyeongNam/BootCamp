package com.encore.OrderService.domain.member.resdto;

import com.encore.OrderService.domain.member.domain.Member;
import com.encore.OrderService.domain.member.domain.Role;
import com.encore.OrderService.domain.ordering.domain.Ordering;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class MemberResMemberDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String role;
    private List<Ordering> orderings;
    private String createdTime;
    private String updatedTime;

    public static Member MemberResMemberDTOToMember(MemberResMemberDTO memberResMemberDTO){
        return Member.builder()
                .id(memberResMemberDTO.getId())
                .name(memberResMemberDTO.getName())
                .email(memberResMemberDTO.getEmail())
                .password(memberResMemberDTO.getPassword())
                .address(memberResMemberDTO.getAddress())
                .orderings(memberResMemberDTO.getOrderings())
                .role(memberResMemberDTO.getRole().equals("ADMIN") ? Role.ADMIN : Role.USER)
                .build();
    }
}
