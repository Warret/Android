package com.example.mytimegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextView textViewOption0;
    private TextView textViewOption1;
    private TextView textViewOption2;
    private TextView textViewOption3;
    private TextView textViewQuestion;
    private TextView textViewNumberQuestion;
    private TextView textViewTimer;

    private int rightAnswer;

    private int min = 5;
    private int max = 50;

    private boolean isPosition;
    private String question;

    private int RightAnswerPosition;

    ArrayList<TextView> btnOption = new ArrayList<>();

    private int CountRightAnswer ;
    private int CountAllAnswer ;

    private boolean playIsRunning = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewOption0 = findViewById(R.id.textViewOption0);
        textViewOption1 = findViewById(R.id.textViewOption1);
        textViewOption2 = findViewById(R.id.textViewOption2);
        textViewOption3 = findViewById(R.id.textViewOption3);
        textViewQuestion = findViewById(R.id.textViewQuestion);
        textViewNumberQuestion = findViewById(R.id.textViewNumberQuestion);
        textViewTimer = findViewById(R.id.textViewTimer);

        btnOption.add(textViewOption0);
        btnOption.add(textViewOption1);
        btnOption.add(textViewOption2);
        btnOption.add(textViewOption3);


        playGame();
        CountDownTimer timer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {
                if (l < 10000) {
                    textViewTimer.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                }
                textViewTimer.setText(getTime(l));
            }

            @Override
            public void onFinish() {
                playIsRunning = false;
                Toast.makeText(MainActivity.this, "Время вышло !", Toast.LENGTH_SHORT).show();

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                int max = preferences.getInt("max", 0);
                if (CountRightAnswer >=  max){
                preferences.edit().putInt("max", CountRightAnswer).apply();
                }

                Intent intent = new Intent(MainActivity.this, FinishActivity.class);
                intent.putExtra("rightAnswer", CountRightAnswer);
                startActivity(intent);
            }
        };
        timer.start();
    }

    private String getTime(long millis) {
        int seconds = (int) (millis / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
    }


    private void playGame() {

        generateQuestion();
        for (int i = 0; i < btnOption.size(); i++) {
            if (i == RightAnswerPosition) {
                btnOption.get(i).setText(Integer.toString(rightAnswer));
            } else {
                btnOption.get(i).setText(Integer.toString(generateWrongAnswer()));
            }
        }


    }

    public void onClickAnswer(View view) {
        if (playIsRunning) {
            TextView textView = (TextView) view;
            String answer = textView.getText().toString();
            int chosenAnswer = Integer.parseInt(answer);
            if (chosenAnswer == rightAnswer) {
                CountRightAnswer++;
                CountAllAnswer++;
                Toast.makeText(getApplicationContext(), "Верно", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Не верно", Toast.LENGTH_SHORT).show();
                CountAllAnswer++;
            }
            String NumberQuestion = String.format("%s/%s", CountRightAnswer, CountAllAnswer);
            textViewNumberQuestion.setText(NumberQuestion);
            playGame();
        }
    }


    private int generateWrongAnswer() {
        int result;
        do {
            result = (int) (Math.random() * max * 2 + 1) - (max - min);
        } while (result == rightAnswer);
        return result;

    }

    private void generateQuestion() {
        int a = (int) (Math.random() * (max - min) + min);
        int b = (int) (Math.random() * (max - min) + min);
        int mark = (int) (Math.random() * 2);
        isPosition = mark == 1;
        if (isPosition) {
            rightAnswer = a + b;
            question = String.format("%s + %s", a, b);
        } else {
            rightAnswer = a - b;
            question = String.format("%s - %s", a, b);
        }
        RightAnswerPosition = (int) (Math.random() * 4);
        textViewQuestion.setText(question);
    }


}