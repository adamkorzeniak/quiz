package com.adamkorzeniak.quiz;

import android.app.Application;

import java.util.List;

public class QuizApplication extends Application {

    private List<QuestionAnswer> questionsList;

    private int quizSize = 20;
    private boolean safeMode = false;

    public int getQuizSize() {
        return quizSize;
    }

    public void setQuizSize(int quizSize) {
        this.quizSize = quizSize;
    }

    public boolean isSafeMode() {
        return safeMode;
    }

    public void setSafeMode(boolean safeMode) {
        this.safeMode = safeMode;
    }


    public List<QuestionAnswer> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<QuestionAnswer> questionsList) {
        this.questionsList = questionsList;
    }
}