package com.adamkorzeniak.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class ConfigurationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        QuizApplication app = (QuizApplication) getApplicationContext();
        int size = app.getQuizSize();
        boolean safeMode = app.isSafeMode();

        EditText quizSizeEditText = findViewById(R.id.quiz_size_text);
        quizSizeEditText.setText(Integer.toString(size));

        CheckBox safeModeCheckbox = findViewById(R.id.safe_mode_checkbox);
        safeModeCheckbox.setChecked(safeMode);

        View.OnClickListener saveSettingsButtonListener = this::saveSettings;
        Button saveButton = findViewById(R.id.save_settings);
        saveButton.setOnClickListener(saveSettingsButtonListener);

        View.OnClickListener revertChangesButtonListener = this::cancelSettings;
        Button cancelButton = findViewById(R.id.cancel_settings);
        cancelButton.setOnClickListener(revertChangesButtonListener);
    }

    private void cancelSettings(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }

    private void saveSettings(View view) {
        QuizApplication app = (QuizApplication) getApplicationContext();

        EditText quizSizeEditText = findViewById(R.id.quiz_size_text);
        String quizSizeString = quizSizeEditText.getText().toString();
        if (!quizSizeString.isEmpty()) {
            int quizSize = Integer.parseInt(quizSizeString);
            app.setQuizSize(quizSize);
        }
        CheckBox safeModeCheckbox = findViewById(R.id.safe_mode_checkbox);
        app.setSafeMode(safeModeCheckbox.isChecked());

        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }
}
