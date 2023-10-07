package com.example.beesang.controller;

import com.example.beesang.repository.UserRepository;
import jakarta.websocket.OnOpen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/info")
    public String readUserInfo() {
        System.out.println("check");
        return "user info test";
    }

    @PostMapping("/info")
    public String readUserInfo2(@RequestBody postData req) {
        return req.id + " : " + req.pw;
    }

    @Data
    @AllArgsConstructor
    public static class postData {
        private String id;
        private String pw;
    }
}
