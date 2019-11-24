package com.adamkorzeniak.quiz;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AnswerAdapter extends ArrayAdapter<Answer> {

    private int resourceLayout;
    private Context mContext;

    public AnswerAdapter(Context context, int resource, List<Answer> answers) {
        super(context, resource, answers);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            LayoutInflater vi = LayoutInflater.from(mContext);
            listItemView = vi.inflate(resourceLayout, null);
        }

        Answer currentAnswer = getItem(position);
        Button currentAnswerButton = listItemView.findViewById(R.id.answer_button);
        currentAnswerButton.setText(currentAnswer.getAnswer());

        return listItemView;
    }
}
