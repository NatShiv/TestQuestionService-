package com.example.tester.controller;

import com.example.tester.exseption.DataEntryError;
import com.example.tester.exseption.QuestionAlreadyAdded;
import com.example.tester.exseption.QuestionNoAdded;
import com.example.tester.model.Question;
import com.example.tester.servise.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService service;

    public JavaQuestionController(@Qualifier("javaQuestionService") QuestionService service) {
        this.service = service;
    }

        @GetMapping
    public List<Question> getAll() {
        return service.getAll();}

    @GetMapping("/add")
    public Question add(@RequestParam(defaultValue = "") String question,
                        @RequestParam(defaultValue = "")String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam(defaultValue = "")String question,
                           @RequestParam(defaultValue = "")String answer) {
        return service.remove(question, answer);
    }
    @ExceptionHandler({QuestionAlreadyAdded.class, QuestionNoAdded.class, DataEntryError.class})
    public String handleException(Exception e) {
        return e.getMessage();
    }
}
