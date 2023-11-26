package com.example.beesang.repository;

import com.example.beesang.domain.assignment.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.expression.spel.ast.Assign;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    @Query("select a from Assignment a order by a.week asc")
    List<Assignment> findAllOrderByWeek();
}
