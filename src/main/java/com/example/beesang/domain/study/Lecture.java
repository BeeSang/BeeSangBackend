package com.example.beesang.domain.study;

import jakarta.persistence.*;

@Entity
public class Lecture {

    @Id @GeneratedValue
    @Column(name = "lecture_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="chapter_id")
    private Chapter chapter;
}
