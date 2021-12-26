package com.example.selectcolor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner ColorSelected;
    private TextView DescColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ColorSelected = findViewById(R.id.color_select);
        DescColor = findViewById(R.id.DescColor);

    }


    public void getColor(View view) {
            int position = ColorSelected.getSelectedItemPosition();
            String description = getDescription(position);
            DescColor.setText(description);

    }

    public String getDescription(int position){
        String[]  description = getResources().getStringArray(R.array.descColor);
        return description[position];
    }
}