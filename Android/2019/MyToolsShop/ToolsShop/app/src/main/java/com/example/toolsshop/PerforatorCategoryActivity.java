package com.example.toolsshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PerforatorCategoryActivity extends AppCompatActivity {

    private ArrayList<Perforator> arrayListPerf ;
    private   ListView listViewPerf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perforator_category);

        arrayListPerf = new ArrayList<>();

        arrayListPerf.add(new Perforator(getString(R.string.perf_gbh_title), getString(R.string.perf_gbh_info), R.drawable.perf_gbh));
        arrayListPerf.add(new Perforator(getString(R.string.perf_instar_title), getString(R.string.perf_instar_info), R.drawable.perf_instar));
        arrayListPerf.add(new Perforator(getString(R.string.perf_pbh_title), getString(R.string.perf_pbh_info), R.drawable.perf_pbh));

        listViewPerf = findViewById(R.id.ListViewPerf);

        ArrayAdapter<Perforator> arrayAdapter =  new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayListPerf);
        listViewPerf.setAdapter(arrayAdapter);

        listViewPerf.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Perforator perforator = arrayListPerf.get(i);
                Intent intent = new Intent(getApplicationContext(), PerforatorDetailActivity.class);
                intent.putExtra("title", perforator.getTitle_perf());
                intent.putExtra("info", perforator.getInfo_perf());
                intent.putExtra("Id_photo", perforator.getImageResourceId_perf());
                startActivity(intent);
            }
        });

    }
}