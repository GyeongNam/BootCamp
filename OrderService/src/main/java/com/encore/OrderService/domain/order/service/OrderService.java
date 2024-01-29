package com.encore.OrderService.domain.order.service;

import com.encore.OrderService.domain.item.domain.Item;
import com.encore.OrderService.domain.item.service.ItemService;
import com.encore.OrderService.domain.member.service.MemberService;
import com.encore.OrderService.domain.order.domain.OrderItem;
import com.encore.OrderService.domain.order.domain.OrderStatus;
import com.encore.OrderService.domain.order.domain.Ordering;
import com.encore.OrderService.domain.order.repository.OrderItemRepository;
import com.encore.OrderService.domain.order.repository.OrderingRepository;
import com.encore.OrderService.domain.order.reqdto.OrderItemReqDTO;
import com.encore.OrderService.domain.order.reqdto.OrderingReqCreateDTO;
import com.encore.OrderService.domain.order.resdto.OrderItemResDTO;
import com.encore.OrderService.domain.order.resdto.OrderingResDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@Transactional
public class OrderService {

    private final OrderingRepository orderingRepository;
    private final OrderItemRepository orderItemRepository;
    private final MemberService memberService;
    private final ItemService itemService;


    @Autowired
    public OrderService(
            OrderingRepository orderingRepository,
            OrderItemRepository orderItemRepository,
            MemberService memberService,
            ItemService itemService
    ){
        this.orderingRepository = orderingRepository;
        this.orderItemRepository = orderItemRepository;
        this.memberService = memberService;
        this.itemService = itemService;
    }

    public Ordering findById(Long id) throws EntityNotFoundException{
       return orderingRepository.findById(id).orElseThrow(()->new EntityNotFoundException("찾을 수 없는 주문입니다."));
    }

    public OrderingResDTO orderAdd(OrderingReqCreateDTO orderingReqCreateDTO) throws EntityNotFoundException {
        if(orderingReqCreateDTO.getItems().isEmpty()){
            throw new EntityNotFoundException("아이템 목록이 존재하지 않습니다.");
        }
        for(OrderItemReqDTO orderItemReqDTO : orderingReqCreateDTO.getItems()) {
            if (itemService.findById(orderItemReqDTO.getItem_id()).getStockQuantity() < orderItemReqDTO.getQuantity()) {
                throw new EntityNotFoundException("재고 부족");
            }
        }

        Ordering ordering = orderingRepository.save(
                OrderingReqCreateDTO.OrderingReqCreateDTOToOrdering(
                        memberService.findById(orderingReqCreateDTO.getMember_id()),
                        OrderStatus.ORDERED
                )
        );

        for(OrderItemReqDTO orderItemReqDTO : orderingReqCreateDTO.getItems()){
            Item item = itemService.findById(orderItemReqDTO.getItem_id());

            orderItemRepository.save(OrderItemReqDTO.OrderingResDTOToOrderItem(
                    ordering, item, orderItemReqDTO
            ));

            item.StockQuantityUpdate(item.getStockQuantity() - orderItemReqDTO.getQuantity());
        }

        return Ordering.OrderingToOrderResDTO(ordering);
    }

    public Page<OrderingResDTO> orderingFindAll(Pageable pageable) {
        return orderingRepository.findAll(pageable).map(
               Ordering::OrderingToOrderResDTO
        );
    }

    public OrderingResDTO orderCancel(Long id) {
        Ordering ordering = this.findById(id);
        for(OrderItem orderItem : ordering.getOrderItems()){
            Item item = itemService.findById(orderItem.getItem().getId());
            item.StockQuantityUpdate(item.getStockQuantity()+orderItem.getQuantity());
        }
        ordering.orderStatusUpdate(OrderStatus.CANCELED);
        return Ordering.OrderingToOrderResDTO(ordering);
    }

    public Page<OrderItemResDTO> orderItemList(Long id, Pageable pageable) {
        return orderItemRepository.findAllByOrderingId(pageable, id)
                .map(OrderItem::OrderItemToOrderItemResDTO);
    }
}
