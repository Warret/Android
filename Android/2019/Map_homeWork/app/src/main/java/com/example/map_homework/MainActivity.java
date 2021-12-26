package com.example.map_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {

    public EditText editTextCountry;
    public EditText editTextCountry2;
    public EditText editTextСapital;
    public TextView textViewCountry;
    public TextView textViewList;
    public Map<String, String> map = new TreeMap<>();

    public String ValuesCountry = "";
    public String KeyCountry = "";
    public String Country2 = "";
    public String Capital = "";
    public String erg = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCountry = findViewById(R.id.editTextCountry);
        editTextCountry2 = findViewById(R.id.editTextCountry2);
        editTextСapital = findViewById(R.id.editTextСapital);
        textViewCountry = findViewById(R.id.textViewCountry);
        textViewList = findViewById(R.id.textViewList);

    }


    public void addKeyValue(View view) {
        Country2 = editTextCountry2.getText().toString();
        Capital = editTextСapital.getText().toString();
        map.put(Country2, Capital);

        for (String key : map.values()) {
            ValuesCountry = key ;
        }
        for (String key : map.keySet()) {
            KeyCountry = key ;
        }

        erg += String.format("%s - %s \n",KeyCountry,ValuesCountry);
        textViewList.setText(erg);

    }


}