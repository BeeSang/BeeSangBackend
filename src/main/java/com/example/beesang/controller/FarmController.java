package com.example.beesang.controller;

import com.example.beesang.domain.farm.Farm;
import com.example.beesang.domain.farm.FarmType;
import com.example.beesang.dto.farm.FarmUserReadResponse;
import com.example.beesang.service.FarmService;
import com.example.beesang.service.UserService;
import com.example.beesang.service.auth.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/farm")
public class FarmController {

    private final FarmService farmService;
    private final UserService userService;
    private final JwtService jwtService;

    @GetMapping("/user")
    public FarmUserReadResponse readUserInfo(HttpHeaders headers) {
        long userId = Long.parseLong(jwtService.getUserId(headers));
        return new FarmUserReadResponse(userService.findUser(userId));
    }

    @GetMapping("/read/{farmType}")
    public void readFarm(@PathVariable(name = "farmType") String farmType, HttpHeaders headers) {
        long userId = Long.parseLong(jwtService.getUserId(headers));

        Farm findFarm = farmService.findFarm(userId, FarmType.valueOf(farmType));
        //return TODO
    }

    //작물 키우기

    //작물 수확하기
}