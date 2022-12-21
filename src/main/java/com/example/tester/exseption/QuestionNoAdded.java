package com.example.tester.exseption;

public class QuestionNoAdded extends RuntimeException{
    public QuestionNoAdded(String message) {
        super(message);
    }
}
