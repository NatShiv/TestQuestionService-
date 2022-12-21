package com.example.tester.servise;

import com.example.tester.model.Question;
import com.example.tester.repository.JavaQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("javaQuestionService")

public class JavaQuestionService implements QuestionService {
    private final JavaQuestionRepository repository;
    static java.util.Random random = new java.util.Random();

    @Autowired
    public JavaQuestionService(JavaQuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        return repository.add(question, answer);
    }

    @Override
    public Question remove(String question, String answer) {
        return repository.remove(question);
    }

    @Override
    public List<Question> getAll() {
        return repository.getAll();
    }

    public int getJavaQuestionSize() {
        return repository.getQuestion().size();
    }


    public Set<String> getRandomQuestion(int num) {
        List<String> questionList = repository.getQuestion();
              Set<String> randomQuestionList = new HashSet<>();
        while (randomQuestionList.size() < num) {
            randomQuestionList.add(questionList.get(generateRandomInt(questionList.size())));
        }

        return randomQuestionList;
    }

    public static int generateRandomInt(int num) {
        return random.nextInt(num);
    }

}
