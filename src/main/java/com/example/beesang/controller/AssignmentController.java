package com.example.beesang.controller;

import com.example.beesang.dto.assignment.AssignmentCreateRequest;
import com.example.beesang.service.assignment.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assignment")
public class AssignmentController {

    private final AssignmentService assignmentService;

    @PostMapping("/create")
    public void createAssignment(@RequestBody AssignmentCreateRequest request) {
        assignmentService.saveAssignment(request);
    }

    //
}
