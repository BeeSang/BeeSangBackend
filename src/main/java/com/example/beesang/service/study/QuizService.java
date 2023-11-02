package com.example.beesang.service.study;

import com.example.beesang.domain.study.Chapter;
import com.example.beesang.domain.study.Quiz;
import com.example.beesang.dto.quiz.QuizCreateRequest;
import com.example.beesang.exception.ExceptionErrorCode;
import com.example.beesang.exception.exceptions.BeesangException;
import com.example.beesang.exception.exceptions.StudyException;
import com.example.beesang.repository.ChapterRepository;
import com.example.beesang.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
    private final ChapterRepository chapterRepository;

    @Transactional
    public void saveQuiz(Long chapterId, QuizCreateRequest request) {
        Chapter chapter = chapterRepository.findById(chapterId)
                .orElseThrow(() -> new StudyException(ExceptionErrorCode.CHAPTER_NOT_FOUND_EXCEPTION, 400));

        quizRepository.save(new Quiz(chapter, request.getTime(), request.getTitle(),
                request.getQuestion(), request.getDescription(), request.isAnswer()));
    }

    public List<Quiz> readQuizAll(Long chapterId) {
        return quizRepository.findAllByChapter_Id(chapterId)
                .orElseThrow(() -> new BeesangException(ExceptionErrorCode.QUIZ_NOT_FOUND_EXCEPTION, 404));
    }
}
