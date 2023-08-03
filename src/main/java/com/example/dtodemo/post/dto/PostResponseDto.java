package com.example.dtodemo.post.dto;

import com.example.dtodemo.user.dto.UserResponseDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostResponseDto {

    private Long id;

    private String title;

    private String content;

    private UserResponseDto user;
}
