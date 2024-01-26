package com.encore.board.post.repository;

import com.encore.board.post.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findByAuthor_Id(Long author_id);

    List<Post> findAllByOrderByCreatedTimeDesc();

    @Query("select p from Post p left outer join p.author ")
    List<Post> findAllJoin();

    @Query("select p from Post p left outer join fetch p.author")
    List<Post> findAllFetchJoin();

    Page<Post> findAll(Pageable pageable);

    Page<Post> findAllByAppointment(Pageable pageable , String appointment);
}


