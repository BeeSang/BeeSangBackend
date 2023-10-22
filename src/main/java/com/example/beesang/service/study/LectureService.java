package com.example.beesang.service.study;

import com.example.beesang.domain.study.Chapter;
import com.example.beesang.domain.study.Lecture;
import com.example.beesang.dto.lecture.LectureCreateRequest;
import com.example.beesang.exception.ExceptionErrorCode;
import com.example.beesang.exception.exceptions.StudyException;
import com.example.beesang.repository.ChapterRepository;
import com.example.beesang.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LectureService {

    private final LectureRepository lectureRepository;
    private final ChapterRepository chapterRepository;

    @Transactional
    public void saveLecture(Long chapterId, LectureCreateRequest request) {
        Chapter chapter = chapterRepository.findById(chapterId)
                .orElseThrow(() -> new StudyException(ExceptionErrorCode.CHAPTER_NOT_FOUND_EXCEPTION, 400));

        lectureRepository.save(new Lecture(chapter, request.getTime(), request.getTitle(), request.getVideoLink()));
    }

    public List<Lecture> readLectureAll(Long chapterId) {
        Chapter chapter = chapterRepository.findById(chapterId)
                .orElseThrow(() -> new StudyException(ExceptionErrorCode.CHAPTER_NOT_FOUND_EXCEPTION, 400));

        return lectureRepository.findAll();
    }
}
