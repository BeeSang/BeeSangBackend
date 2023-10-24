package com.example.beesang.dto.chapter;

import com.example.beesang.domain.study.Chapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChapterReadAllResponse {
    private int week;
    private String title;

    public ChapterReadAllResponse(Chapter chapter) {
        this.week = chapter.getWeek();
        this.title = chapter.getTitle();
    }
}
