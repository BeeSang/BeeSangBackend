package com.example.beesang.controller;

import com.example.beesang.dto.assignment.AssignmentCreateRequest;
import com.example.beesang.service.assignment.AssignmentService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/develop")
public class DevController {
    private final AssignmentService assignmentService;

    @PostMapping("/assignment/create")
    public void createAssignment(@RequestBody DevAssignmentCreateRequest request) {
        for (AssignmentCreateRequest req : request.getRequests()) {
            assignmentService.saveAssignment(req);
        }
    }
}

@Data
class DevAssignmentCreateRequest {
    private List<AssignmentCreateRequest> requests;
}