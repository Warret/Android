package com.example.text_employees;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.text_employees.adapters.EmployeeAdapter;
import com.example.text_employees.api.ApiFactory;
import com.example.text_employees.api.ApiService;
import com.example.text_employees.pojo.Employee;
import com.example.text_employees.pojo.EmployeeResponse;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EmployeeAdapter adapter;
    Disposable disposable;
    CompositeDisposable compositeDisposable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerViewEmployees);
        adapter = new EmployeeAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setEmployees(new ArrayList<Employee>());
        
        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiService();
        compositeDisposable = new CompositeDisposable();
        disposable = apiService.getEmployees()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<EmployeeResponse>() {
                    @Override
                    public void accept(EmployeeResponse employeeResponse) throws Exception {
                        adapter.setEmployees(employeeResponse.getResults());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(MainActivity.this, "Ошибка", Toast.LENGTH_SHORT).show();
                    }
                });
        compositeDisposable.add(disposable);



    }

    @Override
    protected void onDestroy() {
        if (compositeDisposable != null){
            compositeDisposable.dispose();
        }
        super.onDestroy();
    }
}