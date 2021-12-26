package com.example.messenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
        editTextMsg = findViewById(R.id.editTextMessage);
    }

    public void onCLickSendMsg(View view) {
        String msg = editTextMsg.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, msg);
        Intent chosenIntent = intent.createChooser(intent, getString(R.string.name_title));
        startActivity(chosenIntent);
    }
}