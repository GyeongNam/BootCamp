package com.encore.OrderService.domain.member.domain;

import com.encore.OrderService.domain.member.reqdto.MemberReqCreateDTO;
import com.encore.OrderService.domain.member.resdto.MemberResDTO;
import com.encore.OrderService.domain.ordering.domain.Ordering;
import jakarta.persistence.*;
import lombok.*;
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

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String address;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Ordering> orderings;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdTime;

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedTime;

    public static MemberReqCreateDTO MemberToMemberReqCreateDTO(Member member){
        return MemberReqCreateDTO.builder()
                .name(member.getName())
                .email(member.getEmail())
                .password(member.getPassword())
                .address(member.getAddress())
                .role((member.getRole().equals(Role.ADMIN) ? Role.ADMIN : Role.USER).toString())
                .build();
    }

    public static MemberResDTO MemberToMemberResDTO(Member member){
        return MemberResDTO.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .password(member.getPassword())
                .address(member.getAddress())
                .orderings(member.getOrderings())
                .createdTime(member.getCreatedTime().toString())
                .updatedTime(member.getUpdatedTime().toString())
                .role((member.getRole().equals(Role.ADMIN) ? Role.ADMIN : Role.USER).toString())
                .build();
    }

}

