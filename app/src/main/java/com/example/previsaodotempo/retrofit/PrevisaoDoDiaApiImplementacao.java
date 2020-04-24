package com.example.previsaodotempo.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class PrevisaoDoDiaApiImplementacao {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.hgbrasil.com/weather/";

    public static Retrofit getRetrofitInstance(){

        if(retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;

    }
}
