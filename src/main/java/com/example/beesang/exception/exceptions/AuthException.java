package com.example.beesang.exception.exceptions;

import com.example.beesang.exception.ExceptionErrorCode;
import lombok.Getter;

@Getter
public class AuthException extends BeesangException {

    public AuthException(ExceptionErrorCode errorCode, int status) {
        super(errorCode, status);
    }
}