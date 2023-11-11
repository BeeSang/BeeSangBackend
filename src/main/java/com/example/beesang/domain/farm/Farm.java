package com.example.beesang.domain.farm;

import com.example.beesang.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
public class Farm {

    @Id @GeneratedValue
    @Column(name = "farm_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private int crops1;
    private int crops2;
    private int crops3;

    public Farm(User user) {
        this.user = user;
        this.crops1 = 1;
        this.crops2 = 1;
        this.crops3 = 1;
    }

    public void setCorps(int...corps) {
        int corps1 = corps[0];
        int corps2 = corps[1];
        int corps3 = corps[2];
    }
}