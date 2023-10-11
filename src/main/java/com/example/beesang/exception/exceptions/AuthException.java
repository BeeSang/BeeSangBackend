package com.example.beesang.exception.exceptions;

import com.example.beesang.exception.ExceptionErrorCode;
import lombok.Getter;

@Getter
public class AuthException extends RuntimeException {
    private ExceptionErrorCode authErrorCode;
    private String message;
    private int status;

    public AuthException(ExceptionErrorCode authErrorCode, int status) {
        super(authErrorCode.getStatusMessage());
        this.authErrorCode = authErrorCode;
        this.message = authErrorCode.getStatusMessage();
        this.status = status;
    }
}
