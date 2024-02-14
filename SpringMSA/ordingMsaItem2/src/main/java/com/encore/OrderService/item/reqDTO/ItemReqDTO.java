package com.encore.OrderService.domain.item.reqDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
public class ItemReqDTO {
    private String name;
    private String category;
    private long price;
    private long stockQuantity;
    private MultipartFile itemImage;
}
