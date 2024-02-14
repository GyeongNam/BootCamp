package com.encore.OrderService.common;

import com.encore.OrderService.domain.member.domain.Member;
import com.encore.OrderService.domain.member.domain.Role;
import com.encore.OrderService.domain.member.repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitialDataLoader implements CommandLineRunner {
    // CommandLineRunner를 통해 스프링빈으로 등록되는 시점에 run 메서드 실행
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public InitialDataLoader(
            MemberRepository memberRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if(memberRepository.findByEmail("admin@test.com").isEmpty()){
            Member adminMember = Member.builder()
                    .name("admin")
                    .email("admin@test.com")
                    .password(passwordEncoder.encode("1234"))
                    .role(Role.ADMIN)
                    .build();
            memberRepository.save(adminMember);
        }
    }
}
