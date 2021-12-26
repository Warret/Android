package com.example.mycafeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewName = findViewById(R.id.editTextName);
        textViewPassword = findViewById(R.id.editTextPassword);


    }

    public void OnClickOrder(View view) {

        String name = textViewName.getText().toString().trim();
        String password = textViewPassword.getText().toString().trim();

        if(!name.isEmpty() && !password.isEmpty() ){
            Intent intent = new Intent(this, SelectOrder.class);
            intent.putExtra("name", name);
            intent.putExtra("password", password);
            startActivity(intent);
        }
        else {
            Toast.makeText(this,"Все поля должны быть заполнены !", Toast.LENGTH_SHORT).show();
        }

    }
}