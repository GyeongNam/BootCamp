package com.encore.OrderService.domain.order.reqdto;

import com.encore.OrderService.domain.order.domain.OrderItem;
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
    private Long member_id;
    private List<OrderItemReqDTO> items;
}
