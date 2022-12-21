package com.example.tester.repository;

import com.example.tester.model.Question;

import java.util.List;
public interface QuestionRepository {

    Question add(String question, String answer);

    Question remove(String question);

    List<Question> getAll();

}
