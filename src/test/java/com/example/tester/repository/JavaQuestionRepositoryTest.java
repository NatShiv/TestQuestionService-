package com.example.tester.repository;

import com.example.tester.exseption.QuestionAlreadyAdded;
import com.example.tester.exseption.QuestionNoAdded;
import com.example.tester.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class JavaQuestionRepositoryTest {

    JavaQuestionRepository repository = new JavaQuestionRepository();

    public static final String QUESTION = "Why?";
    public static final String ANSWER = "Because!";

    public static final String QUESTION_NO_ADD = "Why???";
    public static final String ANSWER_NO_ADD = "Because!!!";


    @BeforeEach
    void generateQuestionBookExpected() {
        repository.add("QQ","WW");
        repository.add("Qqq","WWw");
        repository.add("QQqq","WWww");

        repository.add(QUESTION, ANSWER);
    }


    @Test
    void add() {
        Question question = new Question(QUESTION_NO_ADD, ANSWER_NO_ADD);
        Assertions.assertEquals(question, repository.add(QUESTION_NO_ADD, ANSWER_NO_ADD));
    }

    @Test
    void remove() {
        Question question = new Question(QUESTION, ANSWER);
        Assertions.assertEquals(question, repository.remove(QUESTION));
    }

    @Test
    void get() {
        Question question = new Question(QUESTION, ANSWER);
             Assertions.assertEquals(question, repository.get(QUESTION));
    }

    @Test
    void getAll() {
        List<Question> questionBookExpected  = List.of(new Question("QQ","WW"),new Question("Qqq","WWw"),
                new Question("QQqq","WWww"),new Question(QUESTION, ANSWER));

        Assertions.assertArrayEquals(questionBookExpected.toArray(),repository.getAll().toArray());
    }


    @Test
    void addAlreadyAddedError() {
        Assertions.assertThrows(QuestionAlreadyAdded.class, () -> repository.add(QUESTION, ANSWER));
    }

    @Test
    void removeNoAddedError() {
        Assertions.assertThrows(QuestionNoAdded.class, () -> repository.remove(QUESTION_NO_ADD));
    }

    @Test
    void getNoAddedError() {
        Assertions.assertThrows(QuestionNoAdded.class, () -> repository.get(QUESTION_NO_ADD));
    }

}