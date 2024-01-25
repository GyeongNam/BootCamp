package com.encore.board.author.service;

import com.encore.board.author.domain.Author;
import com.encore.board.author.domain.Role;
import com.encore.board.author.dto.AuthorDetailResDto;
import com.encore.board.author.dto.AuthorListResDto;
import com.encore.board.author.dto.AuthorSaveDto;
import com.encore.board.author.dto.AuthorUpdateDto;
import com.encore.board.author.repository.AuthorRepository;
import com.encore.board.post.domain.Post;
import com.encore.board.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final PostRepository postRepository;
    @Autowired
    public AuthorService(
            AuthorRepository authorRepository,
            PostRepository postRepository
    ){
        this.authorRepository = authorRepository;
        this.postRepository = postRepository;
    }

    public void save(AuthorSaveDto authorSaveDto){
        Role role = authorSaveDto.getRole() == null || authorSaveDto.getRole().equals("user") ? Role.USER : Role.ADMIN ;
        // 일반 생성자 방식
//        Author author = new Author(
//                authorSaveDto.getName(),
//                authorSaveDto.getEmail(),
//                authorSaveDto.getPassword(),
//                role
//        );

//        List<Post> posts = new ArrayList<>();
        // @Builder를 이용한 방식
        Author author = Author.builder()
                .name(authorSaveDto.getName())
                .email(authorSaveDto.getEmail())
                .password(authorSaveDto.getPassword())
                .role(role)
//                .posts(posts)
                .build();
        /*
        cascade.persist test
        부모 테이블을 통해 자식 테이블에 객체를 동시에 생성
        */
//        Post post = Post.builder()
//                .title("cascade test")
//                .contents("cascade is 좋은말할때 힘내")
//                .author(author)
//                .build();
//        posts.add(post);
//        // author.setPosts(posts);
//        author.getPosts().add(post);
//        System.out.println(author.toString());

        authorRepository.save(author);
    }

    public List<AuthorListResDto> findAll(){
        List<Author> authorList = authorRepository.findAll();
        List<AuthorListResDto> listResDtos = new ArrayList<>();
        for(Author author : authorList){
            AuthorListResDto authorListResDto = new AuthorListResDto();
            authorListResDto.setId(author.getId());
            authorListResDto.setName(author.getName());
            authorListResDto.setEmail(author.getEmail());
            listResDtos.add(authorListResDto);
        }
        return listResDtos;
    }

    public Author findById(Long id) throws EntityNotFoundException {
        return authorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public AuthorDetailResDto findAuthorDetail(Long id) throws EntityNotFoundException {
        Author author =  this.findById(id);
        String role = author.getRole() == null || author.getRole() == Role.USER ? "일반 사용자" : "관리자" ;
        AuthorDetailResDto authorDetailResDto = new AuthorDetailResDto();
        authorDetailResDto.setId(author.getId());
        authorDetailResDto.setName(author.getName());
        authorDetailResDto.setEmail(author.getEmail());
        authorDetailResDto.setPassword(author.getPassword());
        authorDetailResDto.setCreatedTime(author.getCreatedTime());
        authorDetailResDto.setPostCount(postRepository.findByAuthor_Id(author.getId()).size());
        authorDetailResDto.setRole(role);
        return authorDetailResDto;
    }

    public Author update(AuthorUpdateDto authorUpdateDto ) throws EntityNotFoundException {
        Author author =  this.findById(authorUpdateDto.getId());
//        author.AuthorUpdate(authorUpdateDto.getName(), authorUpdateDto.getPassword());
        List<Post> posts = new ArrayList<>();

        Post post = Post.builder()
                .title("cascade test" + author.getId() + "update")
                .contents("cascade is 좋은말할때 힘내")
                .author(author)
                .build();
        posts.add(post);

        author = author.toBuilder()
                .name(authorUpdateDto.getName())
                .password(authorUpdateDto.getPassword())
                .posts(posts)
                .build();
        /*
         명시적으로 save를 하지 않더라도 , jpa의 영속성 컨테스트를 통해,
         객체에 변경이 감지(dirty checking) 되면, 트랜잭션이 완료되는 시점에 save 동작.
         */
        // authorRepository.save(author);
         return author;
    };

    public void delete(Long id) throws EntityNotFoundException {
        authorRepository.deleteById(id);
    }

}
