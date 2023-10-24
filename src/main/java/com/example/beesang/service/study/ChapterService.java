package com.example.beesang.service.study;

import com.example.beesang.domain.study.Chapter;
import com.example.beesang.dto.chapter.ChapterCreateRequest;
import com.example.beesang.repository.ChapterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChapterService {

    private final ChapterRepository chapterRepository;

    @Transactional
    public void saveChapter(ChapterCreateRequest request) {
        chapterRepository.save(new Chapter(request.getWeek(), request.getTitle()));
    }

    public List<Chapter> readChapterAll() {
        return chapterRepository.findAll();
    }
}
