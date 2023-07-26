package com.example.dtodemo.user.entity;

import com.example.dtodemo.user.dto.UserRequestDto;
import com.example.dtodemo.user.dto.UserResponseDto;
import com.example.dtodemo.user.dto.UserUpdateDto;
import lombok.*;

import javax.persistence.*;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor
@Entity@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    public void updateUser(UserUpdateDto updateDto){
        if(updateDto.getName() != null)
            this.name = updateDto.getName();
        if(updateDto.getEmail() != null)
            this.email = updateDto.getEmail();
    }
}
