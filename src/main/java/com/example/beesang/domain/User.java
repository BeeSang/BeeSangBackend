package com.example.beesang.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String userid;
    private String password;

    private String username;

    @Enumerated(EnumType.STRING)
    private School school;

    private int schoolId;
}
