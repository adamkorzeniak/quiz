package com.adamkorzeniak.quiz;

public class Answer {

    private String answer;
    private String answerResult;

    public Answer(String answer, String answerResult) {
        this.answer = answer;
        this.answerResult = answerResult;
    }

    public String getAnswer() {
        return answer;
    }

    public String getAnswerResult() {
        return answerResult;
    }
}
