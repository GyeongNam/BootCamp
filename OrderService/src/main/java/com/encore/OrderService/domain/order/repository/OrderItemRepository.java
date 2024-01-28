package com.encore.OrderService.domain.order.repository;

import com.encore.OrderService.domain.order.domain.OrderItem;
import com.encore.OrderService.domain.order.domain.Ordering;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
//    @Query("select oi from OrderItem oi where oi.ordering.id = :id ")
    Page<OrderItem> findAllByOrderingId(Pageable pageable, Long id);
}
