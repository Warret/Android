package com.example.color_descriptor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerColors;
    private TextView textViewDescriptionsTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerColors =findViewById(R.id.spinnerColors);
        textViewDescriptionsTemp = findViewById(R.id.textViewDescriptionTemp);
    }

    public void ShowDescription(View view) {
    int position = spinnerColors.getSelectedItemPosition();
    String  description = getDescriptionByPosition(position);
    textViewDescriptionsTemp.setText(description);
    }

    private  String getDescriptionByPosition (int position){
        String [] description = getResources().getStringArray(R.array.description_of_temp);
        return description[position];
    }
}