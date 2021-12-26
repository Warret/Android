package com.example.toolsshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PerforatorDetailActivity extends AppCompatActivity {

    private ImageView imageViewPhoto;
    private TextView textViewTitlePerf;
    private TextView textViewInfoPerf;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perforator_detail);

        imageViewPhoto = findViewById(R.id.imageViewPhoto);
        textViewTitlePerf = findViewById(R.id.textViewTitlePerf);
        textViewInfoPerf = findViewById(R.id.textViewInfoPerf);


        Intent intent = getIntent();
        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("Id_photo") ){
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int Id_photo = intent.getIntExtra("Id_photo",  -1);

            imageViewPhoto.setImageResource(Id_photo);
            textViewTitlePerf.setText(title);
            textViewInfoPerf.setText(info);
        }
        else {
            Intent intent1 = new Intent(this, PerforatorCategoryActivity.class);
            startActivity(intent1);
        }



    }
}