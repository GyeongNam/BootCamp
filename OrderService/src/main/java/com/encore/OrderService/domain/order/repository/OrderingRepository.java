package com.encore.OrderService.domain.order.repository;

import com.encore.OrderService.domain.order.domain.Ordering;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderingRepository extends JpaRepository<Ordering, Long> {
}
