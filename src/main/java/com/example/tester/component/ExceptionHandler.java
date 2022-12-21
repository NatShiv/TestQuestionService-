package com.example.tester.component;

import com.example.tester.exseption.DataEntryError;
import com.example.tester.exseption.MethodNotAllowed;
import com.example.tester.exseption.QuestionAlreadyAdded;
import com.example.tester.exseption.QuestionNoAdded;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice(basePackages = "com.example.tester.controller")
public class ExceptionHandler {

  @org.springframework.web.bind.annotation.ExceptionHandler({QuestionAlreadyAdded.class, QuestionNoAdded.class, DataEntryError.class})
    public String handleException(Exception e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodNotAllowed.class)
    public String handleExceptionMNA(Exception e) {
        return e.getMessage();
    }


}
