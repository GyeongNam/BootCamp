package com.encore.OrderService.domain.order.resdto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrderingResDTO {
    private Long id;
    private String email;
    private String orderStatus;
    private List<OrderItemResDTO> orderItems;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
