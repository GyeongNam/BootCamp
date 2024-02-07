package com.encore.OrderService.domain.order.resdto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItemResDTO {
    private Long id;
    private Long quantity;
    private Long item_id;
    private String item_name;
    private Long ordering_id;
}
