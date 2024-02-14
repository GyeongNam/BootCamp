package com.encore.OrderService.domain.item.reqDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ItemSearchDTO {

    private String name;
    private String category;

}
