package com.example.beesang.controller;

import com.example.beesang.dto.shcool.SchoolCreateRequest;
import com.example.beesang.dto.shcool.SchoolReadAllResponse;
import com.example.beesang.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/school")
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping("/create")
    public void createSchool(@RequestBody SchoolCreateRequest request) {
        schoolService.saveSchool(request);
    }

    @GetMapping("/readAll")
    public ResponseEntity<SchoolReadAllResponse> readAllSchool() {
        return ResponseEntity.ok(new SchoolReadAllResponse(schoolService.readAllSchool()));
    }
}
