package com.example.beesang.controller;

import com.example.beesang.dto.assignment.AssignmentCreateRequest;
import com.example.beesang.dto.assignment.AssignmentResponse;
import com.example.beesang.service.assignment.AssignmentService;
import com.example.beesang.service.s3.S3Const;
import com.example.beesang.service.s3.S3FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assignment")
public class AssignmentController {

    private final AssignmentService assignmentService;
    private final S3FileService s3FileService;

    @PostMapping("/create")
    public void createAssignment(@RequestBody AssignmentCreateRequest request) {
        assignmentService.saveAssignment(request);
    }

    @GetMapping("/readAll")
    public List<AssignmentResponse> readAllAssignment() {
        return assignmentService.readAllAssignment()
                .stream().map(AssignmentResponse::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/upload")
    public void uploadImage(@RequestParam("file") MultipartFile file) {
        //myassignment 객체 만들고
        //file s3에 업로드
        s3FileService.uploadImage(S3Const.ASSIGNMENT, file);
    }
}
