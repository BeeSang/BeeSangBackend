package com.example.beesang.controller;

import com.example.beesang.dto.assignment.AssignmentCreateRequest;
import com.example.beesang.dto.assignment.AssignmentResponse;
import com.example.beesang.dto.assignment.MyAssignmentReadResponse;
import com.example.beesang.service.assignment.AssignmentService;
import com.example.beesang.service.assignment.MyAssignmentService;
import com.example.beesang.service.auth.JwtService;
import com.example.beesang.service.s3.S3Const;
import com.example.beesang.service.s3.S3FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assignment")
public class AssignmentController {
    private final AssignmentService assignmentService;
    private final MyAssignmentService myAssignmentService;
    private final JwtService jwtService;
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

    @PostMapping("/upload/{assignmentId}")
    public void uploadImage(@RequestHeader HttpHeaders headers,
                            @PathVariable("assignmentId") Long assignmentId,
                            @RequestParam("file") MultipartFile file) {
        long userId = Long.parseLong(jwtService.getUserId(headers));
        String imageName = s3FileService.uploadImage(S3Const.ASSIGNMENT, file);
        myAssignmentService.saveMyAssignment(userId, assignmentId, imageName);
    }

    @GetMapping("/readMyAssignment/{assignmentId}")
    public MyAssignmentReadResponse readMyAssignment(@RequestHeader HttpHeaders headers,
                                                     @PathVariable("assignmentId") Long assignmentId) {
        long userId = Long.parseLong(jwtService.getUserId(headers));
        return myAssignmentService.readMyAssignment(userId, assignmentId);
    }
}
