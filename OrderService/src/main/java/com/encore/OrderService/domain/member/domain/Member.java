package com.encore.OrderService.domain.member.domain;

import com.encore.OrderService.domain.member.resdto.MemberResDTO;
import com.encore.OrderService.domain.order.domain.Ordering;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Embedded
    private Address address;

    @Column(nullable = false)
    @Builder.Default
    @Enumerated(value = EnumType.STRING)
    private Role role = Role.USER;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Ordering> orderings;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdTime;

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedTime;

    public static MemberResDTO MemberToMemberResDTO(Member member){
        return MemberResDTO.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .password(member.getPassword())
                .address(
                        member.getAddress() == null ? null :
                        Address.builder()
                        .city(member.getAddress().getCity())
                        .street(member.getAddress().getStreet())
                        .zipcode(member.getAddress().getZipcode())
                        .build()
                )
                .orderCount(member.getOrderings().size())
                .createdTime(member.getCreatedTime().toString())
                .updatedTime(member.getUpdatedTime().toString())
                .role((member.getRole().toString()))
                .build();
    }

}

