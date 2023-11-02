package com.example.beesang.repository;

import com.example.beesang.domain.assignment.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
}
