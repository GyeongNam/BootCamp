package com.encore.board.post.service;

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
    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public void save(PostCreateDto postCreateDto){
        Post post = new Post(
                postCreateDto.getTitle(),
                postCreateDto.getContents()
        );
        postRepository.save(post);
    }

    public List<PostListDto> findAll(){
        List<Post> PostList = postRepository.findAll();
        List<PostListDto> listDto = new ArrayList<>();
        for(Post post : PostList){
            PostListDto postListDto = new PostListDto();
            postListDto.setId(post.getId());
            postListDto.setTitle(post.getTitle());
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
        postRepository.save(post);
    };

    public void delete(long id) throws EntityNotFoundException {
        postRepository.deleteById(id);
    }

}
