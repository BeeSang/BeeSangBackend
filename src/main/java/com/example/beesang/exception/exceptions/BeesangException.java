package com.example.beesang.exception.exceptions;

import com.example.beesang.exception.ExceptionErrorCode;
import lombok.Getter;

@Getter
public class BeesangException extends RuntimeException {
    private ExceptionErrorCode errorCode;
    private String message;
    private int status;

    public BeesangException(ExceptionErrorCode errorCode, int status) {
        super(errorCode.getStatusMessage());
        this.errorCode = errorCode;
        this.message = errorCode.getStatusMessage();
        this.status = status;
    }
}
