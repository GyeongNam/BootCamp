package com.encore.board.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/*
websecurityconfigureradapter을 상속하는 방식은 지원종료되었다.
*/

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // pre : 사전 , post : 사후, 사전.사후에 인증/권한 검사 어노테이션 사용 가능
public class SecurityConfig {
    @Bean
    public SecurityFilterChain myFilter(HttpSecurity httpSecurity) throws  Exception {
        return httpSecurity
                .csrf().disable()   // csrf 보안 공격에 대한 설정은 하지 않겠다.
                .authorizeRequests()    // 특정 url 대해서는 보안을 인증처리하지 않고, 특정 url 대해서는 인증처리 하겠다는 설정
                    .antMatchers(
                            "/",
                            "/author/create",
                            "/author/login-page"
                    )  // 인증필요없는 페이지
                    .permitAll()
                    .anyRequest().authenticated() // 그 외는 모두 인증 필요
                .and()  // 만약에 세션을 사용하지 않으면 아내 내용을 설정
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .formLogin()
                    .loginPage("/author/login-page")        // 로그인 페이지 설정
                    // 스프링 내장 메서드를 사용하기 위해 /doLogin url 사용
                    .loginProcessingUrl("/doLogin")
                        .usernameParameter("email")
                        .passwordParameter("pw")
                .successHandler(new LoginSuccessHandler())
                .and()
                .logout()
                    // 스프링 내장 메서드를 사용하기 위해 /doLogout url 사용
                    .logoutUrl("/doLogout")
                .and()
                .build();
    }
}
