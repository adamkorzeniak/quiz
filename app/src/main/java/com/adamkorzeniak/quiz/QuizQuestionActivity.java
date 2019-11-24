package com.adamkorzeniak.quiz;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class QuizQuestionActivity extends AppCompatActivity {

    public static final String QUESTION_ID = "questionId";

    private int questionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);

        QuizApplication app = (QuizApplication) getApplicationContext();
        List<QuestionAnswer> questionsList = app.getQuestionsList();
        questionId = getIntent().getExtras().getInt(QUESTION_ID);
        QuestionAnswer questionAnswer = questionsList.get(questionId);

        TextView questionText = findViewById(R.id.question);
        String questionMessage = String.format("%d. %s", questionId + 1, questionAnswer.getQuestion().getQuestion());
        questionText.setText(questionMessage);

        ListView listView = findViewById(R.id.answers_list_view);
        AnswerAdapter answerAdapter = new AnswerAdapter(this, R.layout.answer_button, questionAnswer.getAnswers());
        listView.setAdapter(answerAdapter);

        AdapterView.OnItemClickListener answerClickedListener = this::answerClicked;
        listView.setClickable(true);
        listView.setOnItemClickListener(answerClickedListener);
    }

    private void answerClicked(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(view.getContext(), QuizAnswerResultActivity.class);
        intent.putExtra(QuizAnswerResultActivity.QUESTION_ID, questionId);
        intent.putExtra(QuizAnswerResultActivity.ANSWER_ID, position);
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
