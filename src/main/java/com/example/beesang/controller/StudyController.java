package com.example.beesang.controller;

import com.example.beesang.dto.chapter.ChapterCreateRequest;
import com.example.beesang.dto.chapter.ChapterReadAllResponse;
import com.example.beesang.dto.lecture.LectureCreateRequest;
import com.example.beesang.dto.lecture.LectureReadAllResponse;
import com.example.beesang.dto.quiz.QuizCreateRequest;
import com.example.beesang.dto.quiz.QuizReadAllResponse;
import com.example.beesang.service.study.ChapterService;
import com.example.beesang.service.study.LectureService;
import com.example.beesang.service.study.QuizService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/study")
public class StudyController {

    private final ChapterService chapterService;
    private final LectureService lectureService;
    private final QuizService quizService;

    /** Chapter */
    @PostMapping("/chapter/create")
    public void createChapter(@RequestBody ChapterCreateRequest request) {
        chapterService.saveChapter(request);
    }

    @GetMapping("/chapter/readAll")
    public ResponseEntity<List<ChapterReadAllResponse>> readAllChapter(HttpServletRequest request) {
        return ResponseEntity.ok(
                chapterService.readChapterAll().stream()
                        .map(ChapterReadAllResponse::new)
                        .collect(Collectors.toList())
        );
    }

    /** Lecture */
    @PostMapping("/lecture/create/{chapterId}")
    public void createLecture(@RequestBody LectureCreateRequest request,
                              @PathVariable(name = "chapterId") Long chapterId) {
        lectureService.saveLecture(chapterId, request);
    }

    @GetMapping("/lecture/readAll/{chapterId}")
    public ResponseEntity<List<LectureReadAllResponse>> readAllLecture(@PathVariable(name = "chapterId") Long chapterId) {
        return ResponseEntity.ok(
            lectureService.readLectureAll(chapterId).stream()
                    .map(LectureReadAllResponse::new)
                    .collect(Collectors.toList())
        );
    }


    /** Quiz */
    @PostMapping("/quiz/create/{chapterId}")
    public void createQuiz(@RequestBody QuizCreateRequest request,
                           @PathVariable(name = "chapterId") Long chapterId) {
        quizService.saveQuiz(chapterId, request);
    }

    @GetMapping("/quiz/readAll/{chapterId}")
    public ResponseEntity<List<QuizReadAllResponse>> readAllQuiz(@PathVariable(name = "chapterId") Long chapterId) {
        return ResponseEntity.ok(
                quizService.readQuizAll(chapterId).stream()
                        .map(QuizReadAllResponse::new)
                        .collect(Collectors.toList())
        );
    }
}