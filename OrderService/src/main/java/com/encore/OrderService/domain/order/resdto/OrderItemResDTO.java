package com.encore.OrderService.domain.order.resdto;

import com.encore.OrderService.domain.item.domain.Item;
import com.encore.OrderService.domain.order.domain.Ordering;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItemResDTO {
    private Long id;
    private Long quantity;
    private Long item_id;
    private Long ordering_id;
}
