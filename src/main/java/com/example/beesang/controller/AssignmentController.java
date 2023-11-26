package com.example.beesang.controller;

import com.example.beesang.dto.assignment.AssignmentCreateRequest;
import com.example.beesang.dto.assignment.AssignmentResponse;
import com.example.beesang.service.assignment.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assignment")
public class AssignmentController {

    private final AssignmentService assignmentService;

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
}
