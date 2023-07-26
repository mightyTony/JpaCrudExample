package com.example.dtodemo.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserRequestDto {

    private Long id;

    private String name;

    private String password;

    private String email;
}
