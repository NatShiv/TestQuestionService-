package com.example.tester.repository;

import com.example.tester.exseption.QuestionAlreadyAdded;
import com.example.tester.model.Question;

import java.util.List;
public interface QuestionRepository {

    Question add(String question, String answer) throws QuestionAlreadyAdded;

    Question remove(String question);

    List<Question> getAll();

}
