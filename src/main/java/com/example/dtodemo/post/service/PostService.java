package com.example.dtodemo.post.service;

import com.example.dtodemo.post.dto.PostRequestDto;
import com.example.dtodemo.post.dto.PostResponseDto;
import com.example.dtodemo.post.dto.PostUpdateRequest;
import com.example.dtodemo.post.entity.Post;
import com.example.dtodemo.post.repository.PostRepository;
import com.example.dtodemo.user.dto.UserResponseDto;
import com.example.dtodemo.user.entity.User;
import com.example.dtodemo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public List<Post> getPostsWithUsers(){
        return postRepository.getPostsWithUsers();
    }

    @Transactional
    public Post createPost(PostRequestDto requestDto) {
        User user = userRepository.findById(requestDto.getUserId())
                .orElseThrow(()-> new IllegalArgumentException("유저를 찾을 수 없습니다"));

        Post post = Post.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .user(user)
                .build();
        return postRepository.save(post);
    }


    public PostResponseDto updatePost(Long postId, PostRequestDto requestDto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));

        if (requestDto.getTitle() != null || requestDto.getContent() != null){
            post.update(requestDto.getTitle(), requestDto.getContent());
            post = postRepository.save(post);
        }

        return PostResponseDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .user(new UserResponseDto(post.getUser().getId(),
                        post.getUser().getName(),
                        post.getUser().getEmail()))
                .build();
    }

    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 존재 하지 않습니다."));

        postRepository.deleteById(postId);
    }

    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물 없음"));
    }
}


