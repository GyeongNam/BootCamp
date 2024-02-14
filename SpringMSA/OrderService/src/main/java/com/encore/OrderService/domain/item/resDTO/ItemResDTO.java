package com.encore.OrderService.domain.item.resDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ItemResDTO {
    private Long id;
    private String name;
    private String category;
    private long price;
    private long stockQuantity;
    private String imagePath;
}
