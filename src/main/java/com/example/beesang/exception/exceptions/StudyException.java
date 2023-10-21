package com.example.beesang.exception.exceptions;

import com.example.beesang.exception.ExceptionErrorCode;

public class StudyException extends BeesangException {
    public StudyException(ExceptionErrorCode errorCode, int status) {
        super(errorCode, status);
    }
}
