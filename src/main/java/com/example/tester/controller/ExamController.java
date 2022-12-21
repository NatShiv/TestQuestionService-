package com.example.tester.controller;

import com.example.tester.servise.ExaminerService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping()
public class ExamController {
    private final ExaminerService service;

    public ExamController(ExaminerService service) {
        this.service = service;
    }
@GetMapping("/get/{amount}")
    public Set<String> getRandomQuestion(@PathVariable int amount) {
        return service.getRandomQuestion(amount);
    }


}
