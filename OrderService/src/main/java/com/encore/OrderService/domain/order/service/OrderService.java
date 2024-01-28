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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public OrderingResDTO orderAdd(OrderingReqCreateDTO orderingReqCreateDTO) {
        if(orderingReqCreateDTO.getItems().isEmpty()){
            throw new IllegalArgumentException("아이템 목록이 존재하지 않습니다.");
        }

        Ordering ordering = Ordering.builder()
                .member(memberService.findById(orderingReqCreateDTO.getMember_id()))
                .orderStatus(OrderStatus.ORDERED)
                .build();
        orderingRepository.save(ordering);

        for(OrderItemReqDTO orderItemReqDTO : orderingReqCreateDTO.getItems()){
            Item item = itemService.findById(orderItemReqDTO.getItem_id());
            OrderItem orderItem = OrderItem.builder()
                    .ordering(ordering)
                    .item(item)
                    .quantity(orderItemReqDTO.getQuantity())
                    .build();
            orderItemRepository.save(orderItem);
            if(item.getStockQuantity() < orderItemReqDTO.getQuantity()){
                throw new IllegalArgumentException("재고 부족");
            }
            item.StockQuantityUpdate(item.getStockQuantity() - orderItemReqDTO.getQuantity());
        }

        return Ordering.OrderingToOrderResDTO(orderingRepository.save(ordering));
    }

    public Page<OrderingResDTO> orderingFindAll(Pageable pageable) {
        return orderingRepository.findAll(pageable).map(
               oied -> OrderingResDTO.builder()
                       .id(oied.getId())
                       .member_id(oied.getMember().getId())
                       .orderItems(
                               oied.getOrderItems().stream().map(
                                       oi -> OrderItemResDTO.builder()
                                               .id(oi.getId())
                                               .quantity(oi.getQuantity())
                                               .item_id(oi.getItem().getId())
                                               .ordering_id(oi.getOrdering().getId())
                                               .build()
                               ).toList()
                       )
                       .orderStatus(oied.getOrderStatus().toString())
               .build()
        );
    }

    public OrderingResDTO orderCancel(Long id) {
        Ordering ordering = this.findById(id);
        for(OrderItem orderItem : ordering.getOrderItems()){
            Item item = itemService.findById(orderItem.getItem().getId());
            item.StockQuantityUpdate(item.getStockQuantity()+orderItem.getQuantity());
        }
        ordering.orderStatusUpdate(OrderStatus.CANCELED);
        return OrderingResDTO.builder()
                .id(ordering.getId())
                .member_id(ordering.getMember().getId())
                .orderItems(
                        ordering.getOrderItems().stream().map(
                                oi -> OrderItemResDTO.builder()
                                        .id(oi.getId())
                                        .quantity(oi.getQuantity())
                                        .item_id(oi.getItem().getId())
                                        .ordering_id(oi.getOrdering().getId())
                                        .build()
                        ).toList()
                )
                .orderStatus(ordering.getOrderStatus().toString())
        .build();
    }

    public Page<OrderItemResDTO> orderItemList(Long id, Pageable pageable) {
        return orderItemRepository.findAllByOrderingId(pageable, id)
                .map(
                 oird-> OrderItemResDTO.builder()
                         .id(oird.getId())
                         .quantity(oird.getQuantity())
                         .item_id(oird.getItem().getId())
                         .ordering_id(oird.getOrdering().getId())
                         .build()
                );
    }
}