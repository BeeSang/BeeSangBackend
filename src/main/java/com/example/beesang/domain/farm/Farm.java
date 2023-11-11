package com.example.beesang.domain.farm;

import com.example.beesang.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Farm {

    @Id @GeneratedValue
    @Column(name = "farm_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private FarmType farmType;

    private int crops1;
    private int crops2;
    private int crops3;

    public Farm(User user, FarmType farmType) {
        this.user = user;
        this.farmType = farmType;
        this.crops1 = 1;
        this.crops2 = 1;
        this.crops3 = 1;
    }
}