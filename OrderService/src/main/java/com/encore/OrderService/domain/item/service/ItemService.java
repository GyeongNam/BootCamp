package com.encore.OrderService.domain.item.service;

import com.encore.OrderService.domain.item.domain.Item;
import com.encore.OrderService.domain.item.repository.ItemRepository;
import com.encore.OrderService.domain.item.reqDTO.ItemReqDTO;
import com.encore.OrderService.domain.item.reqDTO.ItemSearchDTO;
import com.encore.OrderService.domain.item.resDTO.ItemResDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
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

    public ItemResDTO save(ItemReqDTO itemReqDTO) {
        MultipartFile multipartFile = itemReqDTO.getItemImage();
        String fileName = multipartFile.getOriginalFilename();
        Item item = Item.builder()
                .name(itemReqDTO.getName())
                .category(itemReqDTO.getCategory())
                .price(itemReqDTO.getPrice())
                .stockQuantity(itemReqDTO.getStockQuantity())
                .build();
        item = itemRepository.save(item);

        Path path = Paths.get("C:\\Users\\Playdata\\Documents\\GitHub\\BootCamp\\OrderService\\src\\main\\java\\com\\encore\\OrderService\\image",  item.getId() + "_" + fileName );
        item.imagePathUpdate(path.toString());
        try {
            byte[] bytes = multipartFile.getBytes();
            Files.write(path, bytes, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new IllegalArgumentException("image not available");
        }

        return ItemResDTO.builder()
                .id(item.getId())
                .name(item.getName())
                .category(item.getCategory())
                .price(item.getPrice())
                .stockQuantity(item.getStockQuantity())
                .imagePath(item.getImagePath())
                .build();
    }

    public ItemResDTO delete(Long id) {
        Item item = this.findById(id);
        item.deleteItem();

        return ItemResDTO.builder()
                .id(item.getId())
                .name(item.getName())
                .category(item.getCategory())
                .price(item.getPrice())
                .stockQuantity(item.getStockQuantity())
                .imagePath(item.getImagePath())
                .build();
    }

    public Resource getImage(Long id) {
        Item item = this.findById(id);
        String imagePath = item.getImagePath();
        Resource resource;
        Path path = Paths.get(imagePath);
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("url error");
        }
        return resource;
    }

    public Item update(Long id , ItemReqDTO itemReqDTO){
        Item item = this.findById(id);
        MultipartFile multipartFile = itemReqDTO.getItemImage();
        String fileName = multipartFile.getOriginalFilename();
        Path path = Paths.get("C:\\Users\\Playdata\\Documents\\GitHub\\BootCamp\\OrderService\\src\\main\\java\\com\\encore\\OrderService\\image",  item.getId() + "_" + fileName );
        item.updateItem(
                itemReqDTO.getName(),
                itemReqDTO.getCategory(),
                itemReqDTO.getPrice(),
                itemReqDTO.getStockQuantity(),
                path.toString()
        );
        try {
            byte[] bytes = multipartFile.getBytes();
            Files.write(path, bytes, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new IllegalArgumentException("image not available");
        }
        return item;
    }

    public Page<ItemResDTO> findAll(ItemSearchDTO itemSearchDTO, Pageable pageable) {
        /*
        검색을 위해 specification 객체 사용
        specification 객체는 복잡한 쿼리를 명세를 이용한 정의하여 쉽게 생성
         */
        Specification<Item> spec = new Specification<Item>() {
            @Override
            /*
            root : 엔티티의 속성을 접근하기 위한 객체
             */
            public Predicate toPredicate(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(itemSearchDTO.getName() != null){
                    predicates.add(criteriaBuilder.like(root.get("name"), "%" + itemSearchDTO.getName() + "%"));
                }
                if(itemSearchDTO.getCategory() != null){
                    predicates.add(criteriaBuilder.like(root.get("category"), "%" + itemSearchDTO.getCategory() + "%"));
                }

                predicates.add(criteriaBuilder.equal(root.get("delYn"), "N"));

                Predicate[] predicatesArr =new Predicate[predicates.size()];
                for (int i = 0; i < predicates.size(); i++) {
                    predicatesArr[i] = predicates.get(i);
                }

                return criteriaBuilder.and(predicatesArr);
            }
        };

        return itemRepository.findAll(spec, pageable).map(
                p -> ItemResDTO.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .category(p.getCategory())
                        .price(p.getPrice())
                        .stockQuantity(p.getStockQuantity())
                        .build()
        );

        //findByNameContainingAndCategoryContainingAndDelYn
//        return itemRepository.findAllByDelYnAndCategoryContainingAndNameContaining(
//                        "N",
//                        itemSearchDTO.getCategory(),
//                        itemSearchDTO.getName(),
//                        pageable)
//                .map(p->ItemResDTO.builder()
//                        .id(p.getId())
//                        .name(p.getName())
//                        .category(p.getCategory())
//                        .price(p.getPrice())
//                        .stockQuantity(p.getStockQuantity())
//                        .build()
//                );
    }
}
