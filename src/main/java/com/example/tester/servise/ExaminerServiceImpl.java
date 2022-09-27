package com.example.tester.servise;

import com.example.tester.exseption.DataEntryError;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final MathQuestionService serviceMath;
    private final JavaQuestionService serviceJava;

    public ExaminerServiceImpl(MathQuestionService serviceMath, JavaQuestionService serviceJava) {
        this.serviceMath = serviceMath;
        this.serviceJava = serviceJava;
    }

    @Override
    public Set<String> getRandomQuestion(int amount) {
        if (amount<=0){
            throw new DataEntryError("Введите положительное число больше 0");
        }
        if (amount > (serviceMath.maxMathQuestionCount + serviceJava.getJavaQuestionSize())) {
            throw new DataEntryError("В списках всего " + (serviceMath.maxMathQuestionCount + serviceJava.getJavaQuestionSize()) + "вопросов. Введите другое число.");
        }

        int num = generateRandomInt(serviceJava.getJavaQuestionSize());

        Set<String> randomQuestionList = new HashSet<>(amount);
       randomQuestionList.addAll(serviceJava.getRandomQuestion(num));

        if (amount >num) {

            randomQuestionList.addAll(serviceMath.generateRandomMathQuestion(amount - num));
        }

        return randomQuestionList;
    }

    public static int generateRandomInt(int num) {
        java.util.Random random = new java.util.Random();
        return random.nextInt(1 + num);
    }
}
