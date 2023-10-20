package com.example.beesang.exception.exceptions;

import com.example.beesang.exception.ExceptionErrorCode;
import lombok.Getter;

@Getter
public class SchoolException extends BeesangException {

    public SchoolException(ExceptionErrorCode errorCode, int status) {
        super(errorCode, status);
    }
}