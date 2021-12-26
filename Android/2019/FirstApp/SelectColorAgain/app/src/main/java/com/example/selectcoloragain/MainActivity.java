package com.example.selectcoloragain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner SelectColor;
    private TextView DescColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SelectColor = findViewById(R.id.ColorSelect);
        DescColor = findViewById(R.id.ColorDesc);
    }


    public void ShowDescColor(View view) {
        int position =  SelectColor.getSelectedItemPosition();
        String  desc = SearchDec(position);
        DescColor.setText(desc);
    }

    public String SearchDec (int position){
        String[] desc =  getResources().getStringArray(R.array.SelectColorDesc);
        return desc[position];
    }
}