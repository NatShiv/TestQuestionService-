package com.example.tester.validator;

import com.example.tester.exseption.DataEntryError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.example.tester.validator.Validator.validate;

class ValidatorTest {
    public static String STRING_NULL;
    public static final String EMPTY_STRING = "";


    @Test
    void validateError() {
        Assertions.assertThrows(DataEntryError.class, () -> validate(STRING_NULL));
        Assertions.assertThrows(DataEntryError.class, () -> validate(EMPTY_STRING));
    }
}