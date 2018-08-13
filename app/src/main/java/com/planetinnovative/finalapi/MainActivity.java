package com.planetinnovative.finalapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button apiIntegration = findViewById(R.id.apiIntegration);
        Button setData = findViewById(R.id.setData);
        apiIntegration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(Constant.BASE_URL).build();
                DataService data = retrofit.create(DataService.class);
                data.getNoteData().enqueue(new Callback<List<DataModel>>() {
                    @Override
                    public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                        System.out.println(response.body().size());
                        System.out.println(response.raw());
                        System.out.println(response.message());
                        System.out.println(response.code());
                    }

                    @Override
                    public void onFailure(Call<List<DataModel>> call, Throwable t) {
                        System.out.println("EROR");
                        System.out.println(t.getMessage());
                    }
                });
            }
        });

        setData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(Constant.BASE_URL).build();
                DataService data = retrofit.create(DataService.class);
                data.setNoteData(167827, "Title mobile", "H", "Title mobile").enqueue(new Callback<DataSetModel>() {
                    @Override
                    public void onResponse(Call<DataSetModel> call, Response<DataSetModel> response) {
                        System.out.println(response.code());
                        System.out.println(response.message());
                        System.out.println(response.body());
                        System.out.println(response.raw());
                    }

                    @Override
                    public void onFailure(Call<DataSetModel> call, Throwable t) {
                        System.out.println("EROR");
                        System.out.println(t.getMessage());
                    }
                });
            }
        });
    }
}
