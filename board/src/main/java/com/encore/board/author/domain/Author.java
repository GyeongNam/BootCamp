package com.encore.board.author.domain;

import com.encore.board.post.domain.Post;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
/*
@Builder 통해 빌더패턴으로 객체 생성
매개변수의 새팅 순서, 매개변수의 개수 등을 유연하게 세팅
 */
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 20, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    /*
    author를 초기화 할때 post 객체가 필요할 시에 서언
    mappedBy의 연관관계의 주인을 명시하고 , fk를 관리하는 변수명을 명시
     */
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
//    @Setter
    private List<Post> posts;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    LocalDateTime createdTime;

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    LocalDateTime updatedTime;

    public void AuthorUpdate(String name, String password){
        this.name = name;
        this.password = password;
    }
}

