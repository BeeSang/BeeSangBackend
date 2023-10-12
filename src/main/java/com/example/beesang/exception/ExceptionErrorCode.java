package com.example.beesang.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionErrorCode {

    //Auth Exception
    AUTHENTICATION_EXCEPTION("로그인 정보가 일치하지 않습니다."),

    //School Exception
    SCHOOL_NOT_FOUND_EXCEPTION("학교 정보를 찾을 수 없습니다."),
    SCHOOL_ALREADY_EXIST_EXCEPTION("이미 존재하는 학교 이름입니다.");



    private final String statusMessage;
}
