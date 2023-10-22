package com.example.beesang.domain.study;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Lecture {

    @Id @GeneratedValue
    @Column(name = "lecture_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="chapter_id")
    private Chapter chapter;

    private int time;
    private String title;
    private String videoLink;

    public Lecture(Chapter chapter, int time, String title, String videoLink) {
        this.time = time;
        this.chapter = chapter;
        this.title = title;
        this.videoLink = videoLink;
    }
}