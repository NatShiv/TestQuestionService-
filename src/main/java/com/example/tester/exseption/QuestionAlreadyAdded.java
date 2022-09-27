package com.example.tester.exseption;

public class QuestionAlreadyAdded extends RuntimeException{
    public QuestionAlreadyAdded(String message) {
        super(message);
    }
}
