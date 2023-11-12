package com.example.beesang.dto.farm;

import com.example.beesang.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FarmUserReadResponse {
    private String username;
    private int coin;
    private int bees;
    private int level;

    public FarmUserReadResponse(User user) {
        this.username = user.getUsername();
        this.coin = user.getCoin();
        this.bees = user.getBees();
        this.level = user.getLevel();
    }
}