package com.encore.OrderService.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JWTprovider {
    public String createToken(String email, String role){
        /*
        claims : 클레임은 토큰 사용자의 대한 속성이나 데이터 포함, 주로 페이로드를 의미
         */

        Claims claims = Jwts.claims().setSubject(email);
        claims.put("role",role);
        Date now = new Date();

        Key key = Keys.hmacShaKeyFor("여기가시크릿키인데좀길게설정해야해".getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .setClaims(claims) // 정보 저장
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + 30 * 60 * 1000L))
                .signWith( key, SignatureAlgorithm.HS256)
                .compact();
    }
}
