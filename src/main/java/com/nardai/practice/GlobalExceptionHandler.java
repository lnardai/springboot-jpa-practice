package com.nardai.practice;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nardai.practice.controller.WrongAnswerException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WrongAnswerException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String handleException(WrongAnswerException exception) {
        return exception.getMessage();
    }
}
