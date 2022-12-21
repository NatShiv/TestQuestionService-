package com.example.tester.servise;

import com.example.tester.model.Question;
import com.example.tester.repository.JavaQuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionRepository repository;
    @InjectMocks
    private JavaQuestionService service;
    List<Question> questionBookExpected = new ArrayList<>();


    @BeforeEach
    void generateQuestionBookExpected() {
        questionBookExpected = List.of(new Question("Question", "Answer"), new Question("Question2", "Answer"), new Question("Question3", "Answer"));
    }

    public static final String QUESTION = "Why?";
    public static final String ANSWER = "Because!";

    public static final String QUESTION_NO_ADD = "Why?";
    public static final String ANSWER_NO_ADD = "Because!";


    @Test
    void add() {
        Question question = new Question(QUESTION_NO_ADD, ANSWER_NO_ADD);
        Mockito.when(repository.add(QUESTION_NO_ADD, ANSWER_NO_ADD)).thenReturn(question);

        Assertions.assertEquals(question, service.add(QUESTION_NO_ADD, ANSWER_NO_ADD));
    }

    @Test
    void remove() {
        Question question = new Question(QUESTION, ANSWER);
        Mockito.when(repository.remove(QUESTION)).thenReturn(question);
        Assertions.assertEquals(question, service.remove(QUESTION, ANSWER));
    }

    @Test
    void getAll() {
        Mockito.when(repository.getAll()).thenReturn(questionBookExpected);


    }

    @Test
    void getJavaQuestionSize() {
        List<String> questionBookExpected = List.of("Question", "Question2", "Question3");

        Mockito.when(repository.getQuestion()).thenReturn(questionBookExpected);
        Assertions.assertEquals(questionBookExpected.size(), service.getJavaQuestionSize());
    }
}