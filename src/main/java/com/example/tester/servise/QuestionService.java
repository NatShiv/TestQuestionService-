package com.example.tester.servise;

import com.example.tester.model.Question;

import java.util.List;

public interface QuestionService {

    Question add(String que, String ans);

    Question remove(String que, String ans);

    List<Question> getAll();

}
