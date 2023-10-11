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
    private String schoolId;

    private String email;
    private String password;
    private String username;

    //register constructor
    public User(School school, UserRegisterRequest request) {
        this.school = school;
        this.schoolId = request.getSchoolId();
        this.email = request. getUserEmail();
        this.password = request.getPassword();
        this.username = request.getUsername();
    }
}
