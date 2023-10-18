package com.example.beesang.domain.study;

import jakarta.persistence.*;

@Entity
public class Quiz {

    @Id @GeneratedValue
    @Column(name ="quiz_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="chapter_id")
    private Chapter chapter;
}
