package com.example.beesang.service.auth;

import com.example.beesang.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtraClaims {

    private Long userId;

    public ExtraClaims(User user) {
        this.userId = user.getId();
    }
}
