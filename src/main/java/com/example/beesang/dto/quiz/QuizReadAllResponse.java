package com.example.beesang.dto.quiz;

import com.example.beesang.domain.study.Quiz;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizReadAllResponse {
    private int time;
    private String title;
    private String question;
    private String description;
    private boolean answer;

    public QuizReadAllResponse(Quiz quiz) {
        this.time = quiz.getTime();
        this.title = quiz.getTitle();
        this.question = quiz.getQuestion();
        this.description = quiz.getDescription();
        this.answer = quiz.isAnswer();
    }
}
