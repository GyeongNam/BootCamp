package com.encore.OrderService.domain.item.service;

import com.encore.OrderService.domain.item.domain.Item;
import com.encore.OrderService.domain.item.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(
        ItemRepository itemRepository
    ) {
        this.itemRepository = itemRepository;
    }

    public Item findById(Long id) throws EntityNotFoundException {
        return itemRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("존재 하지 않는 아이템 입니다."));
    }
}
