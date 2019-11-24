package com.adamkorzeniak.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class QuizAnswerResultActivity extends AppCompatActivity {

    public static final String QUESTION_ID = "questionId";
    public static final String ANSWER_ID = "answerId";

    private boolean hasNextQuestion;

    private int questionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_answer);

        QuizApplication app = (QuizApplication) getApplicationContext();
        List<QuestionAnswer> questionsList = app.getQuestionsList();
        questionId = getIntent().getExtras().getInt(QUESTION_ID);
        int answerId = getIntent().getExtras().getInt(ANSWER_ID);
        QuestionAnswer questionAnswer = questionsList.get(questionId);
        hasNextQuestion = questionId + 1 < questionsList.size();

        TextView questionText = findViewById(R.id.question);
        String questionMessage = String.format("%d. %s", questionId + 1, questionAnswer.getQuestion().getQuestion());
        questionText.setText(questionMessage);

        TextView answerTextView = findViewById(R.id.answer);
        answerTextView.setText(questionAnswer.getAnswers().get(answerId).getAnswer());

        TextView answerResultTextView = findViewById(R.id.answer_result);
        answerResultTextView.setText(questionAnswer.getAnswers().get(answerId).getAnswerResult());

        Button nextQuestionButton = findViewById(R.id.next_question);
        if (!hasNextQuestion) {
            nextQuestionButton.setText(R.string.finish_test);
            View.OnClickListener finishQuizListener = this::finishQuiz;
            nextQuestionButton.setOnClickListener(finishQuizListener);

        } else {
            nextQuestionButton.setText(R.string.next_quiz);
            View.OnClickListener nextQuestionListener = this::nextQuestion;
            nextQuestionButton.setOnClickListener(nextQuestionListener);
        }
    }

    private void finishQuiz(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);

    }

    private void nextQuestion(View view) {
        Intent intent = new Intent(view.getContext(), QuizQuestionActivity.class);
        intent.putExtra(QuizQuestionActivity.QUESTION_ID, questionId + 1);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add_asset) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
