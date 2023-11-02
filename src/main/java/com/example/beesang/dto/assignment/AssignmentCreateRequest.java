package com.example.beesang.dto.assignment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentCreateRequest {
    private int week;
    private String title;
    private String description;
}