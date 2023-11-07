package com.example.beesang.repository;

import com.example.beesang.domain.study.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    Optional<List<Quiz>> findAllByChapter_Id(Long chapterId);
}
