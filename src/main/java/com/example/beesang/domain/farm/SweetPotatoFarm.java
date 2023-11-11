package com.example.beesang.domain.farm;

import com.example.beesang.domain.User;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class SweetPotatoFarm extends Farm {

    public SweetPotatoFarm(User user) {
        super(user);
    }
}
