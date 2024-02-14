package com.encore.OrderService.domain.order.reqdto;

import com.encore.OrderService.domain.item.domain.Item;
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
public class OrderItemReqDTO {
    private Long quantity;
    private Long item_id;

    public static OrderItem OrderingResDTOToOrderItem(
            Ordering ordering,
            Item item,
            OrderItemReqDTO orderItemReqDTO
    ){
        return OrderItem.builder()
                .ordering(ordering)
                .item(item)
                .quantity(orderItemReqDTO.getQuantity())
                .build();
    }
}
