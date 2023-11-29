package com.example.beesang.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionErrorCode {

    //Auth Exception
    AUTHENTICATION_EXCEPTION("로그인 정보가 일치하지 않습니다."),
    USER_NOT_FOUND_EXCEPTION("사용자 정보를 찾을 수 없습니다."),
    USER_EXIST_EXCEPTION("이미 존재하는 아이디입니다."),

    MALFORMED_JWT_EXCEPTION("[손상된 토큰] 잘못된 요청입니다."),
    UNSUPPORTED_JWT_EXCEPTION("[지원하지 않는 토큰] 잘못된 요청입니다."),
    SIGNATURE_EXCEPTION("[지원하지 않는 토큰] 잘못된 요청입니다."),
    ILLEGAL_ARGUMENT_EXCEPTION("[지원하지 않는 토큰] 잘못된 요청입니다."),
    EXPIRED_ACCESS_TOKEN_EXCEPTION("[만료된 접근 토큰] 토큰을 다시 발급받아주세요."),

    //School Exception
    SCHOOL_NOT_FOUND_EXCEPTION("학교 정보를 찾을 수 없습니다."),
    SCHOOL_ALREADY_EXIST_EXCEPTION("이미 존재하는 학교 이름입니다."),

    //Study Exception
    CHAPTER_NOT_FOUND_EXCEPTION("챕터 정보를 찾을 수 없습니다."),
    LECTURE_NOT_FOUND_EXCEPTION("강의 정보를 찾을 수 없습니다."),
    QUIZ_NOT_FOUND_EXCEPTION("퀴즈 정보를 찾을 수 없습니다."),

    //Farm Exception
    FARM_NOT_FOUND_EXCEPTION("농장 정보를 찾을 수 없습니다."),
    NOT_ENOUGH_BEES_EXCEPTION("벌이 부족합니다."),
    NOT_ENOUGH_CROPS_EXCEPTION("농작물이 부족합니다."),


    ASSIGNMENT_NOT_FOUND_EXCEPTION("과제 정보를 찾을 수 없습니다.");


    private final String statusMessage;
}
