package com.example.beesang.service;

import com.example.beesang.domain.School;
import com.example.beesang.domain.User;
import com.example.beesang.dto.user.UserRegisterRequest;
import com.example.beesang.exception.ExceptionErrorCode;
import com.example.beesang.exception.exceptions.AuthException;
import com.example.beesang.repository.SchoolRepository;
import com.example.beesang.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final SchoolRepository schoolRepository;

    @Transactional
    public void register(UserRegisterRequest request) {
        School school = schoolRepository.findByName(request.getSchoolName())
                .orElseThrow(() -> new AuthException(ExceptionErrorCode.SCHOOL_NOT_FOUND_EXCEPTION, 400));

        //요청값 유효성 검사 필요
        User user = new User(school, request);
        userRepository.save(user);
    }

    public void login(String userEmail, String userPassword) {
        //ID, PW 검증
        User findUser = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new AuthException(ExceptionErrorCode.AUTHENTICATION_EXCEPTION, 400));

        if(!findUser.getPassword().equals(userPassword)) {
            throw new AuthException(ExceptionErrorCode.AUTHENTICATION_EXCEPTION, 400);
        }

        //session return
    }
}
