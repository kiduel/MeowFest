package com.example.android.meowfest;

import com.example.android.meowfest.data.Cat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetRetroInstance {
    @GET("/api/cats?page=0")
    Call<List<Cat>> getCats();
}
