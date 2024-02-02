package com.encore.OrderService.domain.item.domain;

import com.encore.OrderService.domain.order.domain.OrderItem;
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
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private long price;

    private long stockQuantity;

    private String imagePath;

    @Builder.Default
    private String delYn = "N";

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdTime;

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedTime;

    public void StockQuantityUpdate(long count){
        this.stockQuantity = count;
    }
    public void imagePathUpdate(String imagePath){
        this.imagePath = imagePath;
    }
    public void deleteItem(){
        this.delYn = "Y";
    }

    public void updateItem(
            String name,
            String category,
            long price,
            long stockQuantity,
            String imagePath
    ){
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.imagePath = imagePath;
    }
}
