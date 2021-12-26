package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DrillDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detail);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();


        TextView textViewTitle = findViewById(R.id.textViewTitle);
        TextView textViewInfo = findViewById(R.id.textViewInfo);
        ImageView imageViewDrill = findViewById(R.id.imageViewDrell);

        Intent intent = getIntent();
        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resId") ){
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int resId = intent.getIntExtra("resId", -1);
            textViewTitle.setText(title);
            textViewInfo.setText(info);
            imageViewDrill.setImageResource(resId);
        }else {
            Intent backIntent = new Intent(this, DrillCategoryActivity.class);
            startActivity(backIntent);
        }

    }
}