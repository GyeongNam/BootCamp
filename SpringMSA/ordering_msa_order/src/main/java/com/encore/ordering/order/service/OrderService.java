package com.encore.ordering.order.service;

import com.encore.ordering.common.CommonResponse;
import com.encore.ordering.order.domain.OrderItem;
import com.encore.ordering.order.domain.Ordering;
import com.encore.ordering.order.dto.*;
import com.encore.ordering.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;
    private final String MEMBER_API = "http://member-service/";
    private final String ITEM_API = "http://item-service/";

    @Autowired
    public OrderService(
            OrderRepository orderRepository,
            RestTemplate restTemplate
    ) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    public Ordering create(List<OrderReqDto> orderReqDtos, String email) {
        String MemberUrl = MEMBER_API + "member/findByEmail?email="+email;

        MemberDto member = restTemplate.getForObject(MemberUrl, MemberDto.class);
        Ordering ordering = Ordering.builder().memberId(member.getId()).build();

        // Ordering 객체가 생성될 때 OrderingItem 객체도 함께 생성 : cascading
        List<ItemQuantityDto> list = new ArrayList<>();
        for (OrderReqDto dto : orderReqDtos) {
            OrderItem orderItem = OrderItem.builder()
                    .itemId(dto.getItemId())
                    .quantity(dto.getCount())
                    .ordering(ordering)
                    .build();
            ordering.getOrderItems().add(orderItem);
//            "item/updateQuantity"
            String ItemUrl = ITEM_API + "item/"+ dto.getItemId();
            ResponseEntity<ItemDto> itemDto = restTemplate.getForEntity(ItemUrl, ItemDto.class);

            if(itemDto.getBody().getStockQuantity() - dto.getCount() < 0) {
                throw new IllegalArgumentException("재고가 부족합니다.");
            }


            int newQuantity = itemDto.getBody().getStockQuantity() - dto.getCount();
            ItemQuantityDto updateDto = new ItemQuantityDto();
            updateDto.setId(dto.getItemId());
            updateDto.setStockQuantity(newQuantity);
            list.add(updateDto);
        }
        Ordering order = orderRepository.save(ordering);
        /*
        orderRepository.save 를 먼저 하믕로써 위 코드에서 에러 발생시 item 서비스 호출하지 않으므로
        트랜잭션 문제 발생하지 않음
        */
        String ItemPatchUrl = ITEM_API + "item/updateQuantity";
        HttpEntity<List<ItemQuantityDto>> httpEntity = new HttpEntity<>(list);

        ResponseEntity<CommonResponse> response = restTemplate
                .exchange(ItemPatchUrl, HttpMethod.POST, httpEntity, CommonResponse.class);
        log.info(response.getBody().getMessage());
        /*
        만약에 위 updateQuantity 이후에 추가적인 로직이 존재할경우에 트랜잭션이슈는 여전히 발생가능홤.
        해결책으로 에러 발생할 가능성이 있는 코드 전체를 try catch 예외 처리 이후에 catch 에서 updateRollbackQuantity 호출
         */

        return order;
//        return null;
    }

    // 1. User who ordered 'order' and ADMIN user can only cancel order.
    // 2. Find logined user.
    // 3. Find Ordering and set status as CANCELED. Then, revoke item stockQuantity.
    public Ordering cancel(Long id) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String email = authentication.getName();
//
//        Ordering ordering = orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("not found order"));
//        if (!ordering.getMember().getEmail().equals(email) && !authentication.getAuthorities().contains((new SimpleGrantedAuthority("ROLE_ADMIN")))) {
//            throw new AccessDeniedException("권한이 없습니다.");
//        }
//        if (ordering.getOrderStatus() == OrderStatus.CANCELED) {
//            throw new IllegalArgumentException("이미 취소된 주문입니다.");
//        }
//        ordering.cancelOrder();
//        for(OrderItem orderItem : ordering.getOrderItems()) {
//            orderItem.getItem().updateStockQuantity(orderItem.getItem().getStockQuantity() + orderItem.getQuantity());
//        }
//        return ordering;
            return null;
    }

    public List<OrderResDto> findAll() {
        List<Ordering> orderings = orderRepository.findAll();
        return orderings.stream().map(o -> OrderResDto.toDto(o)).collect(Collectors.toList());
    }

    // find each user's ordering info
    public List<OrderResDto> findByEmail(Long memberId) {
        List<Ordering> orderings = orderRepository.findByMemberId(memberId);
        return orderings.stream().map(o -> OrderResDto.toDto(o)).collect(Collectors.toList());
    }

//    public List<OrderResDto> findByMember(Long id) {
//        Member member = memberRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("not found email"));
////        List<Ordering> orderings = member.getOrderings();
//        List<Ordering> orderings = orderRepository.findByMemberId(id);
//        return orderings.stream().map(o -> OrderResDto.toDto(o)).collect(Collectors.toList());
//    }

    public List<OrderResDto> findMyOrders(Long memberId) {
        List<Ordering> orderings = orderRepository.findByMemberId(memberId);
        return orderings.stream().map(o -> OrderResDto.toDto(o)).collect(Collectors.toList());
    }

}
