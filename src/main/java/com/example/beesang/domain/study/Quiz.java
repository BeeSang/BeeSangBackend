package com.example.beesang.domain.study;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Quiz {

    @Id @GeneratedValue
    @Column(name ="quiz_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="chapter_id")
    private Chapter chapter;

    private int time;
    private String title;
    private String question;
    private String description;
    private boolean answer;

    public Quiz(Chapter chapter, int time, String title, String question, String description, boolean answer) {
        this.chapter = chapter;
        this.time = time;
        this.title = title;
        this.question = question;
        this.description = description;
        this.answer = answer;
    }
}