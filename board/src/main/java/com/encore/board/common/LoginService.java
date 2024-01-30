package com.encore.board.common;

import com.encore.board.author.domain.Author;
import com.encore.board.author.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class LoginService implements UserDetailsService {

    private final AuthorService authorService;

    @Autowired
    public LoginService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Author author = authorService.findByEmail(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        // ROLE_ 권한 패턴으로 스프링에서 기본적으로 권한 체크
        authorities.add(new SimpleGrantedAuthority(
               "ROLE_" + author.getRole().toString()
        ));

        /*
        매개변수 : userEmail, userPassword, authorities
        해당 메서드에서 return 되는 User 객체는 session 메모리 저장소에 저장되어 계속 사용 가능
         */
        return new User(author.getEmail(), author.getPassword(), authorities);
    }
}