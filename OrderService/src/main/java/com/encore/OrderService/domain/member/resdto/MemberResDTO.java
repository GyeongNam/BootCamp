package com.encore.OrderService.domain.member.resdto;

import com.encore.OrderService.domain.member.domain.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberResDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Address address;
    private String role;
    private long orderCount;
    private String createdTime;
    private String updatedTime;
}
