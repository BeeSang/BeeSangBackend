package com.example.beesang.dto.user;

import com.example.beesang.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponse {
    private final String username;
    private final String schoolName;
    private final String studentId;
    private final String imgPath;

    @Builder
    public UserResponse(User user) {
        this.username = user.getUsername();
        this.schoolName = user.getSchool().getName();
        this.studentId = user.getStudentId();
        this.imgPath = user.getProfileImgPath();
    }
}
