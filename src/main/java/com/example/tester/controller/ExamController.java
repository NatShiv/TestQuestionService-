package com.example.tester.controller;

import com.example.tester.exseption.DataEntryError;
import com.example.tester.servise.ExaminerService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService service;

    public ExamController(ExaminerService service) {
        this.service = service;
    }
@GetMapping("/get")
    public Set<String> getRandomQuestion(@RequestParam(defaultValue = "0") int amount) {
        return service.getRandomQuestion(amount);
    }
    @ExceptionHandler(DataEntryError.class)
    public String handleException(Exception e) {
        return e.getMessage();
    }


}
