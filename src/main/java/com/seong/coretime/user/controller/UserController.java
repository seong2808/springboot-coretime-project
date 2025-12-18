package com.seong.coretime.user.controller;

import com.seong.coretime.user.dto.UserDto;
import com.seong.coretime.user.entity.User;
import com.seong.coretime.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<?> join (@RequestBody UserDto userDto) {
        Long userId = userService.join(new User(userDto.getEmail(), userDto.getPassword(), userDto.getName()));
        return ResponseEntity.ok(userId);
    }
}
