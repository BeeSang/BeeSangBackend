package com.example.beesang.repository;

import com.example.beesang.domain.assignment.MyAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyAssignmentRepository extends JpaRepository<MyAssignment, Long> {
}
