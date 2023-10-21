package com.example.beesang.controller;

import com.example.beesang.dto.chapter.ChapterCreateRequest;
import com.example.beesang.dto.lecture.LectureCreateRequest;
import com.example.beesang.service.ChapterService;
import com.example.beesang.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/study")
public class StudyController {

    private final ChapterService chapterService;
    private final LectureService lectureService;

    @PostMapping("/chapter/create")
    public void createChapter(@RequestBody ChapterCreateRequest request) {
        chapterService.saveChapter(request);
    }

    @PostMapping("/lecture/create/{chapterId}")
    public void createLecture(@RequestBody LectureCreateRequest request,
                              @PathVariable(name = "chapterId") Long chapterId) {
        lectureService.saveLecture(chapterId, request);
    }
}
