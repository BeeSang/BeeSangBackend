package com.example.beesang.service;

import com.example.beesang.domain.School;
import com.example.beesang.dto.shcool.SchoolCreateRequest;
import com.example.beesang.exception.ExceptionErrorCode;
import com.example.beesang.exception.exceptions.SchoolException;
import com.example.beesang.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SchoolService {

    private final SchoolRepository schoolRepository;

    @Transactional
    public void saveSchool(SchoolCreateRequest request) {
        School findSchool = schoolRepository.findByName(request.getSchoolName()).orElse(null);
        if(findSchool == null) {
            School school = new School(request.getSchoolName());
            schoolRepository.save(school);
        } else {
            throw new SchoolException(ExceptionErrorCode.SCHOOL_ALREADY_EXIST_EXCEPTION, 400);
        }
    }

    public List<School> readAllSchool() {
        return schoolRepository.findAll();
    }
}
