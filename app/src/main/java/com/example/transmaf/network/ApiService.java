package com.example.transmaf.network;

import com.example.transmaf.model.Car;
import com.example.transmaf.model.LoginRequest;
import com.example.transmaf.model.LoginResponse;
import com.example.transmaf.model.RegisterRequest;
import com.example.transmaf.model.RegisterResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    //cars
    @GET("cars")
    Call<List<Car>> getAllCars();

    //auth
    @POST("login")
    Call<LoginResponse> login(@Body LoginRequest request);

    @POST("register")
    Call<RegisterResponse> register(@Body RegisterRequest request);
}
