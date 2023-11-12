package com.example.beesang.domain;

import com.example.beesang.dto.user.UserRegisterRequest;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id")
    private School school;

    private int coin;
    private int bees;
    private int level;

    private String studentId;
    private String email;
    private String password;
    private String username;

    //register constructor
    public User(School school, UserRegisterRequest request) {
        this.school = school;
        this.coin = 100;
        this.bees = 7;
        this.level = 1;
        this.studentId = request.getStudentId();
        this.email = request. getUserEmail();
        this.password = request.getPassword();
        this.username = request.getUsername();
    }

    public void updateCoin(int coin) {
        this.coin += coin;
    }
    public void updateBees(int bees) {
        this.bees += bees;
    }
}