package com.example.beesang.dto.quiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizCreateRequest {
    private int time;
    private String title;
    private String question;
    private String description;
    private boolean answer;
}
