package com.example.final_tren_before_wsr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String [] arrayToListView = getResources().getStringArray(R.array.array_to_listView);
        listView = findViewById(R.id.listView);

        ArrayAdapter<Object> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayToListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,  position + "", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), List_item.class);
                intent.putExtra("position_list_item", position + "");
                startActivity(intent);

            }
        });
    }


    public void Btn_onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), List_item.class);
        startActivity(intent);
    }
}