package com.example.beesang.domain.study;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Lecture {

    @Id @GeneratedValue
    @Column(name = "lecture_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="chapter_id")
    private Chapter chapter;

    private String title;
    private String videoLink;

    public Lecture(Chapter chapter, String title, String videoLink) {
        this.chapter = chapter;
        this.title = title;
        this.videoLink = videoLink;
    }
}