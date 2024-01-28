package com.encore.OrderService.domain.order.resdto;

import com.encore.OrderService.domain.member.domain.Member;
import com.encore.OrderService.domain.order.domain.OrderItem;
import com.encore.OrderService.domain.order.domain.OrderStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrderingResDTO {
    private Long id;
    private Long member_id;
    private String orderStatus;
    private List<OrderItemResDTO> orderItems;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
