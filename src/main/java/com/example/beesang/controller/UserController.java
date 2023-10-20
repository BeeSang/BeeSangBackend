package com.example.beesang.controller;

import com.example.beesang.dto.user.UserLoginRequest;
import com.example.beesang.dto.user.UserLoginResponse;
import com.example.beesang.dto.user.UserRegisterRequest;
import com.example.beesang.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody UserRegisterRequest request) {
        userService.register(request);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
        return ResponseEntity.ok(
                new UserLoginResponse(userService.login(request.getUserEmail(), request.getPassword()))
        );
    }
}