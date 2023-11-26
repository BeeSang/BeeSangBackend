package com.example.beesang.repository;

import com.example.beesang.domain.assignment.MyAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyAssignmentRepository extends JpaRepository<MyAssignment, Long> {
    Optional<MyAssignment> findByUserIdAndAssignmentId(long userId, Long assignmentId);
}
