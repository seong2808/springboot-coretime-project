package com.seong.coretime.user.controller;

import com.seong.coretime.user.dto.UserDto;
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

    @PostMapping("/signup")
    public ResponseEntity<?> signup (@RequestBody UserDto userDto) {
        Long userId = userService.signup(userDto);
        return ResponseEntity.ok(userId);
    }
}
