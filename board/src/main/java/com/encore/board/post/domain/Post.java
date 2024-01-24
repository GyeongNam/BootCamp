package com.encore.board.post.domain;

import com.encore.board.author.domain.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 3000)
    private String contents;


    /*
    post 객체 입장에서는 한 사람이 여러 글을 생성할 수 있다.
    @JoinColumn(nullable = false, name = "autor_email", referencedColumnName = "email")
    author_id는 DB의 컬럼명, 별다른 옵션없을 시 author의 pk에 fk 설정
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    LocalDateTime createdTime;

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    LocalDateTime updatedTime;


    public void postUpdate(String title, String contents){
        this.title = title;
        this.contents = contents;
    }
}
