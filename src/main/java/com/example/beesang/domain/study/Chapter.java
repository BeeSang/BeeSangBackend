package com.example.beesang.domain.study;

import jakarta.persistence.*;

@Entity
public class Chapter {

    @Id @GeneratedValue
    @Column(name="chapter_id")
    private Long id;

    private int week;
    private String title;
}
