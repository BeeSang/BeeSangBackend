package com.example.beesang.controller;

import com.example.beesang.dto.assignment.AssignmentCreateRequest;
import com.example.beesang.dto.chapter.ChapterCreateRequest;
import com.example.beesang.dto.lecture.LectureCreateRequest;
import com.example.beesang.dto.quiz.QuizCreateRequest;
import com.example.beesang.repository.ChapterRepository;
import com.example.beesang.service.assignment.AssignmentService;
import com.example.beesang.service.study.ChapterService;
import com.example.beesang.service.study.LectureService;
import com.example.beesang.service.study.QuizService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/develop")
public class DevController {
    private final AssignmentService assignmentService;
    private final ChapterService chapterService;
    private final LectureService lectureService;
    private final QuizService quizService;

    @PostMapping("/assignment/create")
    public void createAssignment(@RequestBody DevAssignmentCreateRequest request) {
        for (AssignmentCreateRequest req : request.getRequests()) {
            assignmentService.saveAssignment(req);
        }
    }

    @PostMapping("/chapter/create")
    public void createChapter(@RequestBody DevChapterCreateRequest request) {
        for (ChapterCreateRequest req : request.getRequests()) {
            chapterService.saveChapter(req);
        }
    }

    @PostMapping("/lecture/create")
    public void createLecture(@RequestBody DevLectureCreateRequest request) {
        for (DevLectureData req : request.getRequests()) {
            lectureService.saveLecture(req.getChapterId(), new LectureCreateRequest(req.getTime(), req.getTitle(), req.getVideoLink()));
        }
    }

    @PostMapping("/quiz/create")
    public void createQuiz(@RequestBody DevQuizCreateRequest request) {
        for (DevQuizData req : request.getRequests()) {
            quizService.saveQuiz(req.getChapterId(), new QuizCreateRequest(req.getTime(), req.getTitle(), req.getQuestion(), req.getDescription(), req.isAnswer()));
        }
    }
}

@Data
class DevQuizData {
    private Long chapterId;
    private int time;
    private String title;
    private String question;
    private String description;
    private boolean answer;
}

@Data
class DevQuizCreateRequest {
    private List<DevQuizData> requests;
}

@Data
class DevLectureData {
    private Long chapterId;
    private int time;
    private String title;
    private String videoLink;
}

@Data
class DevLectureCreateRequest {
    private List<DevLectureData> requests;
}
@Data
class DevChapterCreateRequest {
    private List<ChapterCreateRequest> requests;
}
@Data
class DevAssignmentCreateRequest {
    private List<AssignmentCreateRequest> requests;
}