package com.example.beesang.domain.assignment;

import com.example.beesang.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class MyAssignment {

    @Id @GeneratedValue
    @Column(name = "my_assignment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String imgLink;

    public MyAssignment(Assignment assignment, User user, String imgLink) {
        this.assignment = assignment;
        this.user = user;
        this.imgLink = imgLink;
    }
}