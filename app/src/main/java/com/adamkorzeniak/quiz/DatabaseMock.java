package com.adamkorzeniak.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DatabaseMock {

    private static List<QuestionAnswer> questions = new ArrayList<>();

    public static List<QuestionAnswer> getAllQuestions() {
        if (questions.isEmpty()) {
            initializeQuestions();
        }
        return questions;
    }

    public static List<QuestionAnswer> getRandomQuestions(int amount) {
        if (questions.isEmpty()) {
            initializeQuestions();
        }
        if (amount < 1) {
            return new ArrayList<>();
        }
        List<QuestionAnswer> result = new ArrayList<>(questions);
        Collections.shuffle(result);
        if (amount > questions.size()) {
            return result;
        }
        return result.subList(0, amount);
    }

    private static void initializeQuestions() {
        QuestionAnswer question1 = new QuestionAnswer.Builder()
                .setQuestion("What is the best question")
                .addAnswer("This question", "Yes")
                .addAnswer("Previous one", "This is first question you dumb")
                .addAnswer("Next one", "How would you know?")
                .build();

        QuestionAnswer question2 = new QuestionAnswer.Builder()
                .setQuestion("What is the worst question")
                .addAnswer("This question", "No")
                .addAnswer("Previous one", "No, it was amazing")
                .addAnswer("Next one", "How would you know?")
                .build();


        questions.add(question1);
        questions.add(question2);

    }
}
