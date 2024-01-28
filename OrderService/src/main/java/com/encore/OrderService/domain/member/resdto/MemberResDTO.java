package com.encore.OrderService.domain.member.resdto;

import com.encore.OrderService.domain.member.domain.Member;
import com.encore.OrderService.domain.member.domain.Role;
import com.encore.OrderService.domain.order.domain.Ordering;
import com.encore.OrderService.domain.order.resdto.OrderingResDTO;
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
    private String createdTime;
    private String updatedTime;
}
