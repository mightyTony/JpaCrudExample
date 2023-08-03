package com.example.dtodemo.post.controller;


import com.example.dtodemo.post.dto.PostRequestDto;
import com.example.dtodemo.post.dto.PostResponseDto;
import com.example.dtodemo.post.dto.PostUpdateRequest;
import com.example.dtodemo.post.entity.Post;
import com.example.dtodemo.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Tag(name = "Post", description = "게시글 CRUD API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Operation(summary = "게시글 번호로 게시글 찾기")
    @GetMapping("/{post_id}")
    public ResponseEntity<Post> getById(@PathVariable("post_id") Long id){
        Post post = postService.findById(id);
        return ResponseEntity.ok(post);
    }

    @Operation(summary = "글 쓴 모든 유저 정보")
    @GetMapping("/withUsers")
    public List<Post> getPostWithUsers(){
        return postService.getPostsWithUsers();
    }

    @Operation(summary = "글쓰기")
    @PostMapping("")
    public ResponseEntity<Post> createPost(@RequestBody PostRequestDto requestDto){
        Post post = postService.createPost(requestDto);
        return ResponseEntity.ok(post);
    }

    @Operation(summary = "해당 글 수정")
    @PatchMapping("/{postId}")
    public ResponseEntity<PostResponseDto> updatePost(@PathVariable Long postId,
                                                      @RequestBody PostRequestDto requestDto){
        PostResponseDto post = postService.updatePost(postId, requestDto);
        return ResponseEntity.ok(post);
    }

    @Operation(summary = "해당 글 삭제")
    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId){

        postService.deletePost(postId);

        return ResponseEntity.ok("글이 삭제 되었습니다.");
    }

}
