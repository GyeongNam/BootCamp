package com.encore.board.post.service;

import com.encore.board.author.domain.Author;
import com.encore.board.author.repository.AuthorRepository;
import com.encore.board.post.domain.Post;
import com.encore.board.post.dto.PostCreateDto;
import com.encore.board.post.dto.PostDetailDto;
import com.encore.board.post.dto.PostListDto;
import com.encore.board.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class PostService {
    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;
    @Autowired
    public PostService(
            PostRepository postRepository,
            AuthorRepository authorRepository
    ){
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
    }

    public void save(PostCreateDto postCreateDto, String email){
        /*
         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         authentication.getName() 로 접근가능
         */

        Author author = authorRepository.findByEmail(email).orElse(null);
        LocalDateTime localDateTime = null;
        String appointment = null;
        if(postCreateDto.getAppointment().equals("Y") && !postCreateDto.getAppointmentTime().isEmpty() ){
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            localDateTime = LocalDateTime.parse(postCreateDto.getAppointmentTime(), dateTimeFormatter);
            LocalDateTime now = LocalDateTime.now();
            if(localDateTime.isBefore(now) ){
                throw new IllegalArgumentException("시간정복 잘못 입력");
            }
            appointment = "Y";
        }
        Post post = Post.builder()
                .title(postCreateDto.getTitle())
                .contents(postCreateDto.getContents())
                .author(authorRepository.findByEmail(email).orElse(null))
                .appointment(appointment)
                .appointmentTime(localDateTime)
                .build();

        // 더티 채킹 테스트
//        author.AuthorUpdate("터티 채킹 테스트", "1234");

        postRepository.save(post);
    }

    public List<PostListDto> findAll(){
        List<Post> PostList = postRepository.findAll();
        List<PostListDto> listDto = new ArrayList<>();
        for(Post post : PostList){
            PostListDto postListDto = new PostListDto();
            postListDto.setId(post.getId());
            postListDto.setTitle(post.getTitle());
            postListDto.setAuthor_email(post.getAuthor() == null ? "익명 유저": post.getAuthor().getEmail());
            listDto.add(postListDto);
        }
        return listDto;
    }

    public Page<PostListDto> pageFindAll(Pageable pageable){
        Page<Post> PostList = postRepository.findAllByAppointment(pageable, null);
        Page<PostListDto> listDto = PostList.map(
                p-> new PostListDto(
                        p.getId(),
                        p.getTitle(),
                        p.getAuthor() == null ? "익명유저" : p.getAuthor().getEmail(),
                        p.getAppointment(),
                        p.getAppointmentTime()
                    )
                );
        return listDto;
    }



    public Post findById(long id) throws EntityNotFoundException {
        return postRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public PostDetailDto findPostDetail(long id) throws EntityNotFoundException {
        Post post =  this.findById(id);
        PostDetailDto postDetailDto = new PostDetailDto();
        postDetailDto.setId(post.getId());
        postDetailDto.setTitle(post.getTitle());
        postDetailDto.setContents(post.getContents());
        postDetailDto.setCreatedTime(post.getCreatedTime());
        return postDetailDto;
    }

    public void update(long id, PostCreateDto postCreateDto ) throws EntityNotFoundException {
        Post post =  this.findById(id);
        post.postUpdate(postCreateDto.getTitle(), postCreateDto.getContents());
//        postRepository.save(post);
    };

    public void delete(long id) throws EntityNotFoundException {
        postRepository.deleteById(id);
    }

}
