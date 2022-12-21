package com.example.tester.validator;

import com.example.tester.exseption.DataEntryError;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class Validator {
    public static void validate(String string) {
        if (string == null || string.equals("")) {
            throw new DataEntryError("Нельзя передать пустую строку в качестве вопроса или ответа.");
        }

    }

    public static void validateDouble(String s1,String s2){
        if (s1.equals(s2)){
            throw new DataEntryError("Вопрос и ответ не могут быть одинаковыми!");
        }
    }

    @ExceptionHandler(DataEntryError.class)
    String handleException(Exception e) {
        return e.getMessage();

    }
}
