package com.example.beesang.service.assignment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MyAssignmentService {

    @Transactional
    public void saveMyAssignment() {

    }
}