package com.example.mytimer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTimer;

    private int seconds = 0;
    private boolean isRunning = false;

    private  boolean wasRunning = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            isRunning = savedInstanceState.getBoolean("isRunning");
            }

        textViewTimer = findViewById(R.id.textViewTimer);
        RunTimer();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
        outState.putBoolean("isRunning", isRunning);
    }

    public void TimerStart(View view) {
        isRunning = true;
    }

    public void TimerStop(View view) {
        isRunning = false;
    }

    public void TimerRestart(View view) {
        isRunning = false;
        seconds = 0;
    }




    @Override
    protected void onResume() {
        super.onResume();
        isRunning = wasRunning;
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = isRunning;
        isRunning = false;

    }

    public void RunTimer() {

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int second = seconds % 60;

                String time = String.format(Locale.getDefault(),"%d:%02d:%02d", hours, minutes, second);
                textViewTimer.setText(time);
                if (isRunning)
                    seconds++;

                handler.postDelayed(this, 1000);
            }
        });


    }

}