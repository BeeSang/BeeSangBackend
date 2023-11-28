package com.example.beesang.controller;

import com.example.beesang.dto.user.*;
import com.example.beesang.service.UserService;
import com.example.beesang.service.auth.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final JwtService jwtService;

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

    @GetMapping("/")
    public UserResponse readUser(@RequestHeader HttpHeaders headers) {
        Long userId = Long.parseLong(jwtService.getUserId(headers));
        return UserResponse.builder()
                .user(userService.readUserWithSchool(userId))
                .build();
    }

    @PutMapping("/")
    public void updateUser(@RequestHeader HttpHeaders headers,
                           @RequestBody UserUpdateRequest request) {

    }


}