package com.encore.ordering.order.dto;

import lombok.Data;

@Data
public class ItemQuantityDto {
    private Long id;
    private int stockQuantity;
}
