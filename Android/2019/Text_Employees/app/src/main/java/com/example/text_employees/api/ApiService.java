package com.example.text_employees.api;

import com.example.text_employees.pojo.EmployeeResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("pokemon?offset=80&limit=20")
    Observable<EmployeeResponse> getEmployees();

}
