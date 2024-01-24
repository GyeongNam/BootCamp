package com.encore.board.post.service;

import com.encore.board.author.repository.AuthorRepository;
import com.encore.board.post.domain.Post;
import com.encore.board.post.dto.PostCreateDto;
import com.encore.board.post.dto.PostDetailDto;
import com.encore.board.post.dto.PostListDto;
import com.encore.board.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

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

    public void save(PostCreateDto postCreateDto){
        Post post = Post.builder()
                .title(postCreateDto.getTitle())
                .contents(postCreateDto.getContents())
                .author(authorRepository.findByEmail(postCreateDto.getEmail()).orElse(null))
                .build();
        postRepository.save(post);
    }

    public List<PostListDto> findAll(){
        List<Post> PostList = postRepository.findAllByOrderByCreatedTimeDesc();
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
