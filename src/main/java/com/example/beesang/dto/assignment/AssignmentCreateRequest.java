package com.example.beesang.dto.assignment;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AssignmentCreateRequest {
    private int week;
    private String title;
    private String description;
}