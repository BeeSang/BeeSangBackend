package com.example.beesang.dto.lecture;

import com.example.beesang.domain.study.Lecture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LectureReadAllResponse {
    private int time;
    private String title;
    private String videoLink;

    public LectureReadAllResponse(Lecture lecture) {
        this.time = lecture.getTime();
        this.title = lecture.getTitle();
        this.videoLink = lecture.getVideoLink();
    }
}
