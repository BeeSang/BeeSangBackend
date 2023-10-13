package com.example.beesang.exception;

import com.example.beesang.exception.exceptions.AuthException;
import com.example.beesang.exception.exceptions.SchoolException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(AuthException.class)
    public ResponseEntity<ExceptionResponse> handleAuthException(AuthException e, HttpServletRequest request) {
        log.error("ERROR: {}, URL: {}, MESSAGE: {}, STATUS: {}", e.getAuthErrorCode(),
                request.getRequestURI(), e.getMessage(), e.getStatus());
        return ResponseEntity.status(e.getStatus()).body(new ExceptionResponse(e.getAuthErrorCode(), e.getMessage()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(SchoolException.class)
    public ResponseEntity<ExceptionResponse> handleSchoolException(AuthException e, HttpServletRequest request) {
        log.error("ERROR: {}, URL: {}, MESSAGE: {}, STATUS: {}", e.getAuthErrorCode(),
                request.getRequestURI(), e.getMessage(), e.getStatus());
        return ResponseEntity.status(e.getStatus()).body(new ExceptionResponse(e.getAuthErrorCode(), e.getMessage()));
    }
}
