package com.example.tester.exseption;

public class DataEntryError extends RuntimeException{
    public DataEntryError(String message) {
        super(message);
    }
}
