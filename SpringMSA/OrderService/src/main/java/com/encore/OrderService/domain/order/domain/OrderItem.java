package com.encore.OrderService.domain.order.domain;

import com.encore.OrderService.domain.item.domain.Item;
import com.encore.OrderService.domain.order.resdto.OrderItemResDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordering_id", nullable = false)
    private Ordering ordering;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdTime;

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedTime;

    public static OrderItemResDTO OrderItemToOrderItemResDTO(OrderItem orderItem){
        return OrderItemResDTO.builder()
                .id(orderItem.getId())
                .quantity(orderItem.getQuantity())
                .item_name(orderItem.getItem().getName())
                .item_id(orderItem.getItem().getId())
                .ordering_id(orderItem.getOrdering().getId())
                .build();
    }

}
