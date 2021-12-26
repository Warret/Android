package com.example.final_tren_before_wsr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class List_item extends AppCompatActivity {

    private TextView textViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        textViewName = findViewById(R.id.textView4);
//         String fgd= getIntent().getExtras().getString("position_list_item");
        Intent intent = getIntent();
        if ( intent.hasExtra("position_list_item")){
            String position_list_item = intent.getStringExtra("position_list_item");
            textViewName.setText(position_list_item);
        }


    }
}