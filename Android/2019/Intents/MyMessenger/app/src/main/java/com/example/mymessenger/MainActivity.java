package com.example.mymessenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText Msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Msg = findViewById(R.id.MsgName);
    }

    public void openIntent(View view) {
        String msg = Msg.getText().toString();
//        Intent intent = new Intent(this, SecondActivity.class);
//        intent.putExtra("msg", msg);
//        startActivity(intent);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,msg);
        Intent newIntent = new Intent(Intent.createChooser(intent,getString(R.string.msg_chooser)));
        startActivity(newIntent);
    }
}