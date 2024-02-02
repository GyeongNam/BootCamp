package com.encore.OrderService.domain.item.repository;

import com.encore.OrderService.domain.item.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Page<Item> findAllByDelYnAndCategoryContainingAndNameContaining(
            String delYn,
            String category,
            String name,
            Pageable pageable
    );

    Page<Item> findAll(Specification<Item> spec, Pageable pageable);
}
