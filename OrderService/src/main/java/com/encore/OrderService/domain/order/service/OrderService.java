package com.encore.OrderService.domain.order.service;

import com.encore.OrderService.domain.item.domain.Item;
import com.encore.OrderService.domain.item.service.ItemService;
import com.encore.OrderService.domain.member.domain.Member;
import com.encore.OrderService.domain.member.repository.MemberRepository;
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

    public OrderingResDTO orderAdd(OrderingReqCreateDTO orderingReqCreateDTO) {
        if(orderingReqCreateDTO.getItems().size() == 0){
            throw new IllegalArgumentException("아이템 목록이 존재하지 않습니다.");
        }

        Ordering ordering = Ordering.builder()
                .member(memberService.findById(orderingReqCreateDTO.getMember_id()))
                .orderStatus(OrderStatus.ORDERED)
                .build();
        orderingRepository.save(ordering);

        for(OrderItemReqDTO orderItemReqDTO : orderingReqCreateDTO.getItems()){
            Item item = itemService.findById(orderItemReqDTO.getItem_id());
            OrderItem orderItem= OrderItem.builder()
                    .ordering(ordering)
                    .item(item)
                    .quantity(orderItemReqDTO.getQuantity())
                    .build();
            orderItemRepository.save(orderItem);
            if(item.getStockQuantity() < orderItemReqDTO.getQuantity()){
                throw new IllegalArgumentException("재고 부족");
            }
            item.StockQuantityUpdate(orderItemReqDTO.getQuantity());
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
}
