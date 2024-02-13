package com.encore.OrderService.domain.order.reqdto;

import com.encore.OrderService.domain.member.domain.Member;
import com.encore.OrderService.domain.order.domain.OrderStatus;
import com.encore.OrderService.domain.order.domain.Ordering;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderingReqCreateDTO {
    @Builder.Default
    private Long member_id = 0L;
    private List<OrderItemReqDTO> items;

    public static Ordering OrderingReqCreateDTOToOrdering(Member member, OrderStatus orderStatus){
        return Ordering.builder()
                .member(member)
                .orderStatus(orderStatus)
                .build();
    }

}
