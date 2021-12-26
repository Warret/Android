package com.example.traffic_light;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout listView_green;
    private LinearLayout listView_yellow;
    private LinearLayout listView_red;
    private boolean start_stop = false;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView_green = findViewById(R.id.green_color);
        listView_yellow = findViewById(R.id.yellow_color);
        listView_red = findViewById(R.id.red_color);
        button = findViewById(R.id.button);

    }






    public void StartOrStop(View view) {
//        if (start_stop) start_stop = false;
//        else if (!start_stop) start_stop = true;.
        if (!start_stop) {
            start_stop = true;
            button.setText("Stop");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (start_stop) {

                        try {
                            listView_green.setBackgroundColor(getResources().getColor(R.color.green));
                            Thread.sleep(2000);
                            listView_green.setBackgroundColor(getResources().getColor(R.color.gray));
                            listView_yellow.setBackgroundColor(getResources().getColor(R.color.yellow));
                            Thread.sleep(2000);
                            listView_yellow.setBackgroundColor(getResources().getColor(R.color.gray));
                            listView_red.setBackgroundColor(getResources().getColor(R.color.red));
                            Thread.sleep(2000);
                            listView_red.setBackgroundColor(getResources().getColor(R.color.gray));

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }).start();
        }else {
            start_stop = false;
            button.setText("Start");
        }

    }
}