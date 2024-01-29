package com.encore.OrderService.domain.order.repository;

import com.encore.OrderService.domain.member.domain.Member;
import com.encore.OrderService.domain.order.domain.Ordering;
import jakarta.persistence.criteria.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderingRepository extends JpaRepository<Ordering, Long> {
    Page<Ordering>findAllByMemberId(Pageable pageable, Long id);
}
