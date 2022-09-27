package com.example.tester.repository;

import com.example.tester.exseption.QuestionAlreadyAdded;
import com.example.tester.exseption.QuestionNoAdded;
import com.example.tester.model.Question;
import com.example.tester.validator.Validator;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class JavaQuestionRepository implements QuestionRepository {

    Map<String, Question> questionBook;

    public JavaQuestionRepository() {
        this.questionBook = new HashMap<>();
    }

    @Override
    public Question add(String question, String answer) throws QuestionAlreadyAdded {
        Validator.validate(question);
        Validator.validate(answer);
        if (questionBook.containsKey(question)) {
            throw new QuestionAlreadyAdded("Такой вопрос уже был добавлен.");
        }
        Question qa = new Question(question, answer);
        questionBook.put(question, qa);
        return qa;
    }

    @Override
    public Question remove(String question) {
        Validator.validate(question);
        if (!questionBook.containsKey(question)) {
            throw new QuestionNoAdded("Такой вопрос не добавлен.");
        }
        return questionBook.remove(question);
    }

    public Question get(String question) {
        Validator.validate(question);
        if (!questionBook.containsKey(question)) {
            throw new QuestionNoAdded("Такой вопрос не добавлен.");
        }
        return questionBook.get(question);
    }

    @Override
    public List<Question> getAll() {
        if (questionBook.size() == 0) {
            throw new QuestionNoAdded("Список вопросов пуст.");
        }
        return new ArrayList<>(questionBook.values());
    }

    public List<String> getQuestion() {
        if (questionBook.size() == 0) {
            throw new QuestionNoAdded("Список вопросов пуст.");}

        return new ArrayList<>(questionBook.keySet());

    }

    @PostConstruct
    public void init() {
            questionBook.put("QuestionText", new Question("QuestionText", "QuestionAnswer"));
    }
}
