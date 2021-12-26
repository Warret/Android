package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listViewTools;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar !=null){
            actionBar.hide();
        }
        listViewTools =findViewById(R.id.listViewTools);
        listViewTools.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
             switch (position){
                 case 0:
                     Intent intent = new Intent(getApplicationContext(),DrillCategoryActivity.class);
                     startActivity(intent);
                     break;
                 case 1:
                     Intent intent2 = new Intent(getApplicationContext(),PerforatorCategoryActivity.class);
                     startActivity(intent2);
                     break;
             }
            }
        });
    }
}