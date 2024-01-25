package com.encore.board.author.service;

import com.encore.board.author.domain.Author;
import com.encore.board.author.dto.AuthorDetailResDto;
import com.encore.board.author.dto.AuthorUpdateDto;
import com.encore.board.author.repository.AuthorRepository;
import com.encore.board.post.domain.Post;
import com.encore.board.post.repository.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class AuthorServiceTest {
    @Autowired
    AuthorService authorService;
    @Autowired
    PostRepository postRepository;

    // 가짜객체를 만드는 작업을 목킹이라고 한다
    @MockBean
    private AuthorRepository authorRepository;

    @Test
    void findAuthorDetailTest(){
        Long authorId = 1L;
        List<Post> posts = new ArrayList<>();
        Post post = Post.builder()
                .title("hello")
                .contents("hello word")
                .build();
        posts.add(post);
        Author author = Author.builder()
                .id(authorId)
                .name("test1")
                .email("test1@naver.com")
                .password("1234")
                .posts(posts)
                .build();
        Mockito.when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));
        AuthorDetailResDto authorDetailResDto =  authorService.findAuthorDetail(authorId);
        Assertions.assertEquals(author.getName(), authorDetailResDto.getName());
        Assertions.assertEquals(author.getPosts().size(), authorDetailResDto.getPostCount());
        Assertions.assertEquals("일반유저", authorDetailResDto.getRole());
    }

    @Test
    public void updateTest(){
        Long author_id = 1L;

        Author author = Author.builder()
                .name("test1")
                .email("test1@naver.com")
                .password("1234")
                .build();

        Mockito.when(authorRepository.findById(author_id)).thenReturn(Optional.of(author));

        AuthorUpdateDto authorUpdateDto = new AuthorUpdateDto();
        authorUpdateDto.setName("test2");
        authorUpdateDto.setPassword("test2@naver.com");
        authorUpdateDto.setId(author_id);

        Author author_new = authorService.update(authorUpdateDto);

        Assertions.assertEquals(author_new.getName(), authorUpdateDto.getName());
    }

    @Test
    public void findAllTest(){
        int beforeCount = authorService.findAll().size();

        // Mock repository 기능 구현
        List<Author> authors = new ArrayList<>();
        authors.add(new Author());
        authors.add(new Author());
        Mockito.when(authorRepository.findAll()).thenReturn(authors);

        // 검증
        Assertions.assertEquals(2, authorService.findAll().size());

    }
}
