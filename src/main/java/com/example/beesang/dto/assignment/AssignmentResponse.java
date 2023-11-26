package com.example.beesang.dto.assignment;

import com.example.beesang.domain.assignment.Assignment;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AssignmentResponse {
    private final Long assignmentId;
    private final int week;
    private final String title;
    private final String description;

    @Builder
    public AssignmentResponse(Assignment assignment) {
        this.assignmentId = assignment.getId();
        this.week = assignment.getWeek();
        this.title = assignment.getTitle();
        this.description = assignment.getDescription();
    }
}
