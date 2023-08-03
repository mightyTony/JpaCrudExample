package com.example.dtodemo.post.repository;


import com.example.dtodemo.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p JOIN FETCH p.user")
    List<Post> getPostsWithUsers();

}
