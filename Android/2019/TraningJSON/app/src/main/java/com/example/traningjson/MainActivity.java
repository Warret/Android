package com.example.traningjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DownloadJSONTask task = new DownloadJSONTask();
        task.execute("https://www.cbr-xml-daily.ru/daily_json.js");
//        new DownloadJSONTask().execute("https://www.cbr-xml-daily.ru/daily_json.js");

    }

}