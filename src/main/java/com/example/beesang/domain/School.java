package com.example.beesang.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class School {

    @Id @GeneratedValue
    @Column(name = "school_id")
    private Long id;

    private String name;

    public School(String name) {
        this.name = name;
    }
}