package com.example.tester.model;

import com.example.tester.validator.Validator;

public class Question {
    private final String question;
    private final String answer;

    public Question(String question, String answer) {
        Validator.validate(question);
        Validator.validate(answer);
        Validator.validateDouble(question,answer);
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;

        Question question1 = (Question) o;

        if (!question.equals(question1.question)) return false;
        return answer.equals(question1.answer);
    }

    @Override
    public int hashCode() {
        int result = question.hashCode();
        result = 31 * result + answer.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Вопрос :" + question + '\n' +
                "Ответ :'" + answer;
    }
  }
