package com.example.android.meowfest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.android.meowfest.data.Cat;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.cats_rv)
    RecyclerView cats_rv;

    public static ArrayList<Cat> cats_av = new ArrayList<>();
    Cats_rvAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        /*Create handle for the RetrofitInstance interface*/
        GetRetroInstance service = RetroInstance.getRetrofitInstance().create(GetRetroInstance.class);
        Call<List<Cat>> cats = service.getCats();
        cats.enqueue(new Callback<List<Cat>>() {
            @Override
            public void onResponse(Call<List<Cat>> call, Response<List<Cat>> response) {
                generateCats(response.body());
            }

            @Override
            public void onFailure(Call<List<Cat>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "No cats", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateCats(List<Cat> cats) {
        adapter = new Cats_rvAdapter(this, new ArrayList<>(cats));
        cats_rv.setAdapter(adapter);
        cats_rv.setLayoutManager(new LinearLayoutManager(this));

    }
}
