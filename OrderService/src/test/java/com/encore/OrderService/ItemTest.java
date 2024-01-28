package com.encore.OrderService;

import com.encore.OrderService.domain.item.domain.Item;
import com.encore.OrderService.domain.item.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemTest {
    @Autowired
    ItemRepository itemRepository;
    @Test
    public void ItemAdd(){
        Item item = Item.builder()
                .name("사과")
                .price(1000)
                .stockQuantity(10)
                .build();
        itemRepository.save(item);

        item = Item.builder()
                .name("바나나")
                .price(1500)
                .stockQuantity(20)
                .build();
        itemRepository.save(item);

        item = Item.builder()
                .name("배")
                .price(2000)
                .stockQuantity(5)
                .build();
        itemRepository.save(item);

        item = Item.builder()
                .name("귤")
                .price(200)
                .stockQuantity(20)
                .build();
        itemRepository.save(item);
    }
}
