package com.example.dtodemo.post.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Builder
public class PostUpdateRequest {

    @NotNull
    @Size(max = 20)
    private String title;

    private String content;
}
