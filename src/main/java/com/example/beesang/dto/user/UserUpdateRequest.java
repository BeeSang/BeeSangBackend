package com.example.beesang.dto.user;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private String username;
    private String schoolName;
    private String studentId;
}
