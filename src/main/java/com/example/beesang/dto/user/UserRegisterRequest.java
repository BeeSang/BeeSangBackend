package com.example.beesang.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {
    private String schoolName;
    private String studentId;
    private String userEmail;
    private String password;
    private String checkPassword;
    private String username;
}
