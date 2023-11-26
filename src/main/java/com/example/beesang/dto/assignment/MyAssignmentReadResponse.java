package com.example.beesang.dto.assignment;

import lombok.Getter;

@Getter
public class MyAssignmentReadResponse {
    private String imgLink;

    public MyAssignmentReadResponse(String imgLink) {
        this.imgLink = imgLink;
    }
}
