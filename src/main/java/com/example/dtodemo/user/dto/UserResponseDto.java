package com.example.dtodemo.user.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {

    private Long id;

    private String name;

    private String email;
}
