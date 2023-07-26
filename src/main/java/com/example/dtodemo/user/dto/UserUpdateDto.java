package com.example.dtodemo.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserUpdateDto {

    private String name;
    private String email;
}
