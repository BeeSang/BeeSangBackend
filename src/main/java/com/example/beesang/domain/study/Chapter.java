package com.example.beesang.domain.study;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Chapter {

    @Id @GeneratedValue
    @Column(name="chapter_id")
    private Long id;

    private int week;
    private String title;

    public Chapter(int week, String title) {
        this.week = week;
        this.title = title;
    }
}
