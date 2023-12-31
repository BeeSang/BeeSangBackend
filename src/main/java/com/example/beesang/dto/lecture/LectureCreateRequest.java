package com.example.beesang.dto.lecture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LectureCreateRequest {
    private int time;
    private String title;
    private String videoLink;
}