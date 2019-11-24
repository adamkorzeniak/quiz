package com.adamkorzeniak.quiz;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class QuestionAnswer {

    private static int questionId = 1;

    private final Question question;
    private final List<Answer> answers;

    private QuestionAnswer(Question question, List<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }

    public Question getQuestion() {
        return question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public static class Builder {
        private Question question;
        private List<Answer> answers = new ArrayList<>();

        public Builder() {}

        public Builder setQuestion(String question) {
            this.question = new Question(questionId++, question);
            return this;
        }

        public Builder addAnswer(String answer, String answerResult) {
            answers.add(new Answer(answer, answerResult));
            return this;
        }

        public QuestionAnswer build() {
            if (question == null) {
                throw new RuntimeException("Question cannot be empty");
            }
            if (answers.isEmpty()) {
                throw new RuntimeException("Answers cannot be empty");
            }
            return new QuestionAnswer(question, answers);
        }

    }
}
