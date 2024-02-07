package com.encore.OrderService.domain.order.domain;

import com.encore.OrderService.domain.member.domain.Member;
import com.encore.OrderService.domain.order.resdto.OrderingResDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ordering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Member member;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "ordering", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdTime;

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedTime;

    public static OrderingResDTO OrderingToOrderResDTO(Ordering ordering){
        if(ordering.getOrderItems() == null){
            return OrderingResDTO.builder()
                    .id(ordering.getId())
                    .email(ordering.getMember().getEmail())
                    .orderStatus(ordering.getOrderStatus().toString())
                    .createdTime(ordering.getCreatedTime())
                    .updatedTime(ordering.getUpdatedTime())
                    .build();
        }else{
            return OrderingResDTO.builder()
                    .id(ordering.getId())
                    .email(ordering.getMember().getEmail())
                    .orderStatus(ordering.getOrderStatus().toString())
                    .orderItems(ordering.getOrderItems().stream().map(
                            OrderItem::OrderItemToOrderItemResDTO
                    ).toList())
                    .createdTime(ordering.getCreatedTime())
                    .updatedTime(ordering.getUpdatedTime())
                    .build();
        }

    }
    public void orderStatusUpdate(OrderStatus orderStatus){
        this.orderStatus = orderStatus;
    }
}
