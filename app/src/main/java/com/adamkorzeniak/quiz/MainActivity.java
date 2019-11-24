package com.adamkorzeniak.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener startNewQuizListener = this::startNewQuiz;

        Button startQuizButton = findViewById(R.id.start_quiz_button);
        startQuizButton.setOnClickListener(startNewQuizListener);
    }

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add_asset) {
            Intent intent = new Intent(this, ConfigurationActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void startNewQuiz(View v) {

        QuizApplication app = (QuizApplication) getApplicationContext();
        List<QuestionAnswer> questionAnswers = DatabaseMock.getRandomQuestions(2);
        app.setQuestionsList(questionAnswers);

        Intent intent = new Intent(v.getContext(), QuizQuestionActivity.class);
        intent.putExtra("questionId", 0);
        startActivity(intent);
    }
}
