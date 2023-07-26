package com.example.dtodemo.user.service;

import com.example.dtodemo.user.dto.UserRequestDto;
import com.example.dtodemo.user.dto.UserResponseDto;
import com.example.dtodemo.user.dto.UserUpdateDto;
import com.example.dtodemo.user.entity.User;
import com.example.dtodemo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto findById(Long id){
        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("유저 못 찾았음"));

        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    @Transactional
    public User createUser(UserRequestDto requestDto){

        User user = User.builder()
                .name(requestDto.getName())
                .password(requestDto.getPassword())
                .email(requestDto.getEmail())
                .build();

        return userRepository.save(user);
    }

    @Transactional
    public UserResponseDto update(Long id, UserUpdateDto updateDto){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("유저 못찾겠어"));

        user.updateUser(updateDto);

        return UserResponseDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public List<User> findAllUser() {
        Iterable<User> all = userRepository.findAll();

        return (List<User>) all;
    }

    public void deleteById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("해당 ID 유저가 존재 하지 않습니다."));

        userRepository.deleteById(user.getId());
    }
}
