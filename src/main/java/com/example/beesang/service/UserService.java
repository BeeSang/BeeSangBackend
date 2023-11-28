package com.example.beesang.service;

import com.example.beesang.domain.School;
import com.example.beesang.domain.User;
import com.example.beesang.dto.user.UserRegisterRequest;
import com.example.beesang.dto.user.UserUpdateRequest;
import com.example.beesang.exception.ExceptionErrorCode;
import com.example.beesang.exception.exceptions.AuthException;
import com.example.beesang.exception.exceptions.BeesangException;
import com.example.beesang.repository.FarmRepository;
import com.example.beesang.repository.SchoolRepository;
import com.example.beesang.repository.UserRepository;
import com.example.beesang.service.auth.ExtraClaims;
import com.example.beesang.service.auth.JwtService;
import com.example.beesang.service.s3.S3Const;
import com.example.beesang.service.s3.S3FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final SchoolRepository schoolRepository;
    private final FarmService farmService;

    private final JwtService jwtService;
    private final S3FileService s3FileService;

    @Transactional
    public void register(UserRegisterRequest request) {
        School school = schoolRepository.findByName(request.getSchoolName())
                .orElseThrow(() -> new AuthException(ExceptionErrorCode.SCHOOL_NOT_FOUND_EXCEPTION, 404));

        //요청값 유효성 검사 필요
        User user = new User(school, request);
        userRepository.save(user);

        farmService.createFarms(user);
    }

    public String login(String userEmail, String userPassword) {
        //ID, PW validation
        User findUser = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new AuthException(ExceptionErrorCode.AUTHENTICATION_EXCEPTION, 403));

        if(!findUser.getPassword().equals(userPassword)) {
            throw new AuthException(ExceptionErrorCode.AUTHENTICATION_EXCEPTION, 403);
        }

        //return token
        return jwtService.generateAccessToken(findUser, new ExtraClaims(findUser));
    }

    public User findUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new AuthException(ExceptionErrorCode.USER_NOT_FOUND_EXCEPTION, 404));
    }

    public User readUserWithSchool(Long userId) {
        return userRepository.findByIdWithSchool(userId)
                .orElseThrow(() -> new AuthException(ExceptionErrorCode.USER_NOT_FOUND_EXCEPTION, 404));
    }

    @Transactional
    public void uploadProfileImg(Long userId, MultipartFile file) {
        User findUser = userRepository.findById(userId)
                .orElseThrow(() -> new AuthException(ExceptionErrorCode.USER_NOT_FOUND_EXCEPTION, 404));

        String imgPath = s3FileService.uploadImage(S3Const.USER, file);
        findUser.setProfileImgPath(imgPath);
    }

    @Transactional
    public void updateUser(Long userId, UserUpdateRequest request) {
        User findUser = userRepository.findById(userId)
                .orElseThrow(() -> new AuthException(ExceptionErrorCode.USER_NOT_FOUND_EXCEPTION, 404));

        School findSchool = schoolRepository.findByName(request.getSchoolName())
                .orElseThrow(() -> new BeesangException(ExceptionErrorCode.SCHOOL_NOT_FOUND_EXCEPTION, 404));

        findUser.update(request.getUsername(), findSchool, request.getStudentId());
    }
}
