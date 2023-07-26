package com.example.dtodemo.user.controller;

import com.example.dtodemo.user.dto.UserRequestDto;
import com.example.dtodemo.user.dto.UserResponseDto;
import com.example.dtodemo.user.dto.UserUpdateDto;
import com.example.dtodemo.user.entity.User;
import com.example.dtodemo.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User", description = "유저 CRUD API")
@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원 찾기", description = "ID를 통해 회원 정보 가져오기")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id){
        UserResponseDto byId = userService.findById(id);
        return ResponseEntity.ok(byId);
    }

    @Operation(summary = "회원 가입", description = "회원 가입하기")
    @PostMapping("/")
    public ResponseEntity<String> createUser(@RequestBody UserRequestDto requestDto){
        User user = userService.createUser(requestDto);
        return ResponseEntity.ok("안녕하세요. 환영합니다" + user.getName() + "님 ");
    }

    @Operation(summary = "회원 정보 수정", description = "회원 이름, 이메일 수정 기능")
    @PatchMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserUpdateDto userUpdateDto){

        UserResponseDto update = userService.update(id, userUpdateDto);

        return ResponseEntity.ok(update.getName()+"\n"+update.getEmail());
    }

    @Operation(summary = "모든 회원 정보", description = "전체 회원 정보 가져오기")
    @GetMapping("/all")
    public ResponseEntity<List> findAllUser(){

        List<User> userList = userService.findAllUser();
        return ResponseEntity.ok(userList);
    }

    @Operation(summary = "회원 정보 삭제", description = "ID 정보를 통해 회원 정보 삭제")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){

        UserResponseDto byId = userService.findById(id);
        userService.deleteById(id);

        return ResponseEntity.ok(byId.getName() + " 님 계정 삭제 완료 되었습니다.");
    }
}
