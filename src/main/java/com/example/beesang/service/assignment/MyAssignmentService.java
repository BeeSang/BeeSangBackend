package com.example.beesang.service.assignment;

import com.example.beesang.domain.User;
import com.example.beesang.domain.assignment.Assignment;
import com.example.beesang.domain.assignment.MyAssignment;
import com.example.beesang.dto.assignment.MyAssignmentReadResponse;
import com.example.beesang.exception.ExceptionErrorCode;
import com.example.beesang.exception.exceptions.BeesangException;
import com.example.beesang.repository.AssignmentRepository;
import com.example.beesang.repository.MyAssignmentRepository;
import com.example.beesang.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MyAssignmentService {
    private final MyAssignmentRepository myAssignmentRepository;
    private final UserRepository userRepository;
    private final AssignmentRepository assignmentRepository;

    @Transactional
    public void saveMyAssignment(Long userId, Long assignmentId, String imgLink) {
        User findUser = userRepository.findById(userId)
                .orElseThrow(() -> new BeesangException(ExceptionErrorCode.USER_NOT_FOUND_EXCEPTION, 404));
        Assignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new BeesangException(ExceptionErrorCode.ASSIGNMENT_NOT_FOUND_EXCEPTION, 404));

        findUser.updateBees(10);
        myAssignmentRepository.save(new MyAssignment(assignment, findUser, imgLink));
    }

    public MyAssignmentReadResponse readMyAssignment(long userId, Long assignmentId) {
        Optional<MyAssignment> myAssignment = myAssignmentRepository.findByUserIdAndAssignmentId(userId, assignmentId);

        if(myAssignment.isPresent()) {
            return new MyAssignmentReadResponse(myAssignment.get().getImgLink());
        } else {
            return new MyAssignmentReadResponse("No Image");
        }
    }
}