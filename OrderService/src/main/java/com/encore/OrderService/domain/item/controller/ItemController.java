package com.encore.OrderService.domain.item.controller;

import com.encore.OrderService.common.CommonResponse;
import com.encore.OrderService.domain.item.reqDTO.ItemReqDTO;
import com.encore.OrderService.domain.item.reqDTO.ItemSearchDTO;
import com.encore.OrderService.domain.item.resDTO.ItemResDTO;
import com.encore.OrderService.domain.item.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/item/create")
    public ResponseEntity<CommonResponse> itemCreate(ItemReqDTO itemReqDTO){
        return CommonResponse.responseMassage(HttpStatus.CREATED,
                    itemService.save(itemReqDTO)
                );
    }

    @GetMapping("/items")
    public ResponseEntity<CommonResponse> items(ItemSearchDTO itemSearchDTO , Pageable pageable){
        Page<ItemResDTO> itemResDTOS = itemService.findAll(itemSearchDTO, pageable);
        log.info(itemResDTOS.getContent().size()+"");
        return CommonResponse.responseMassage(HttpStatus.OK,itemResDTOS);
    }

    @GetMapping("/item/{id}/image")
    public ResponseEntity<Resource> getItem(@PathVariable Long id){
        Resource resource = itemService.getImage(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(resource, httpHeaders, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/item/{id}/update")
    public ResponseEntity<CommonResponse> itemUpdate(
            @PathVariable Long id,
            ItemReqDTO itemReqDTO
    ){
        return CommonResponse.responseMassage(HttpStatus.CREATED,itemService.update(id,itemReqDTO));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/item/{id}/delete")
    public ResponseEntity<CommonResponse> itemDelete(
            @PathVariable Long id
    ){
        return CommonResponse.responseMassage(HttpStatus.CREATED,itemService.delete(id));
    }

}
