package com.example.beesang.service.assignment;

import com.example.beesang.domain.assignment.Assignment;
import com.example.beesang.dto.assignment.AssignmentCreateRequest;
import com.example.beesang.repository.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    @Transactional
    public void saveAssignment(AssignmentCreateRequest request) {
        assignmentRepository.save(new Assignment(request.getWeek(), request.getTitle(), request.getDescription()));
    }

    public List<Assignment> readAllAssignment() {
        return assignmentRepository.findAllOrderByWeek();
    }
}