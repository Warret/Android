package com.example.mytimegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import java.util.prefs.Preferences;

public class FinishActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        textView = findViewById(R.id.textView);


        Intent intent = getIntent();
        if (intent.hasExtra("rightAnswer")) {
            int rightAnswer = intent.getIntExtra("rightAnswer", 0);
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            int max = preferences.getInt("max", 0);
            String strAnswer = String.format("Ваш результат: %s\nРекорд: %s", rightAnswer, max);
            textView.setText(strAnswer);
        }
    }

    public void onClickRestart(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void onClickZero(View view) {
        Intent intent = getIntent();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.edit().putInt("max", 0).apply();
        if (intent.hasExtra("rightAnswer")) {
            int rightAnswer = intent.getIntExtra("rightAnswer", 0);
            int record = preferences.getInt("max", 0);
            String strAnswer = String.format("Ваш результат: %s\nРекорд: %s", rightAnswer, record);
            textView.setText(strAnswer);
        }
    }
}