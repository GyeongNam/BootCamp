package com.encore.OrderService.domain.order.repository;

import com.encore.OrderService.domain.order.domain.OrderItem;
import com.encore.OrderService.domain.order.domain.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
