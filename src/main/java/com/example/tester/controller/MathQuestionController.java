package com.example.tester.controller;

import com.example.tester.model.Question;
import com.example.tester.servise.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {
    private final QuestionService service;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Question> getAll() {
        return service.getAll();
    }

    @GetMapping("/add")
    public Question add(@RequestParam(defaultValue = "") String question,
                        @RequestParam(defaultValue = "") String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam(defaultValue = "") String question,
                           @RequestParam(defaultValue = "") String answer) {
        return service.remove(question, answer);
    }
}
