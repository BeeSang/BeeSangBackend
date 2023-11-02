package com.example.beesang.domain.assignment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Assignment {

    @Id @GeneratedValue
    @Column(name = "assignment_id")
    private Long id;

    private int week;
    private String title;
    private String description;

    public Assignment(int week, String title, String description) {
        this.week = week;
        this.title = title;
        this.description = description;
    }
}
