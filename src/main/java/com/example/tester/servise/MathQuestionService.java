package com.example.tester.servise;

import com.example.tester.exseption.MethodNotAllowed;
import com.example.tester.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {

    private Map<String, List<String>> constantRandomMath = new HashMap<>();

    List<String> question = List.of("Что такое ", "Назавите формулу площади  ", "Назавите формулу  объема ");
    List<String> que1 = List.of("квадрат?", "прямоугольник?", "треугольник?", "прямая?", "отрезок?");
    List<String> que2 = List.of("куба.", "параллелограмма.", "трапеции?", "шара?", "многоугольника? ");

    int maxMathQuestionCount = question.size() * (que1.size() + 2 * que2.size());


    public Set<String> generateRandomMathQuestion(int num) {
              constantRandomMath.put("Что такое ", que1);
        constantRandomMath.put("Назавите формулу площади  ", que2);
        constantRandomMath.put("Назавите формулу  объема ", que2);
        Set<String> randomQuestionList = new HashSet<>();
        while (randomQuestionList.size() < num) {
            String key = question.get(generateRandomInt(question.size()-1));
            randomQuestionList.add(key + constantRandomMath.get(key).get(generateRandomInt(5)));
        }
               return randomQuestionList;
    }

    public static int generateRandomInt(int num) {

        java.util.Random random = new java.util.Random();
        return random.nextInt(num);
    }



    @Override
    public Question add(String que, String ans) {
        throw new MethodNotAllowed();
    }

    @Override
    public Question remove(String que, String ans) {
        throw new MethodNotAllowed();
    }

    @Override
    public List<Question> getAll() {
        throw new MethodNotAllowed();
    }
}

