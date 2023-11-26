package com.example.beesang.controller;

import com.example.beesang.domain.farm.Farm;
import com.example.beesang.domain.farm.FarmType;
import com.example.beesang.dto.farm.FarmReadResponse;
import com.example.beesang.dto.farm.FarmUpdateRequest;
import com.example.beesang.dto.farm.FarmUpdateResponse;
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

    @GetMapping("/user") //API TEST 완료 (2023-11-12)
    public FarmUserReadResponse readUserInfo(@RequestHeader HttpHeaders headers) {
        long userId = Long.parseLong(jwtService.getUserId(headers));
        return new FarmUserReadResponse(userService.findUser(userId));
    }

    @GetMapping("/read") //API TEST 완료 (2023-11-12)
    public FarmReadResponse readFarm(@RequestParam(value="farmType") String farmType,
                                     @RequestHeader HttpHeaders headers) {
        long userId = Long.parseLong(jwtService.getUserId(headers));

        Farm findFarm = farmService.findFarm(userId, FarmType.valueOf(farmType));
        return new FarmReadResponse(findFarm);
    }

    @PostMapping("/grow/{farmId}") //API TEST 완료 (2023-11-12)
    public FarmUpdateResponse growCrops(@PathVariable(name="farmId") Long farmId,
                                        @RequestBody FarmUpdateRequest request,
                                        @RequestHeader HttpHeaders headers) {
        Long userId = Long.parseLong(jwtService.getUserId(headers));
        farmService.growCrops(farmId, userId, request);
        return new FarmUpdateResponse(request.getCrops1(), request.getCrops2(), request.getCrops3());
    }

    @PostMapping("/harvest/{farmId}") //API TEST 완료 (2023-11-12)
    public FarmUpdateResponse harvestCrops(@PathVariable(name="farmId") Long farmId,
                             @RequestBody FarmUpdateRequest request,
                             @RequestHeader HttpHeaders headers) {
        Long userId = Long.parseLong(jwtService.getUserId(headers));
        farmService.harvestCrops(farmId, userId, request);
        return new FarmUpdateResponse(request.getCrops1(), request.getCrops2(), request.getCrops3());
    }
}