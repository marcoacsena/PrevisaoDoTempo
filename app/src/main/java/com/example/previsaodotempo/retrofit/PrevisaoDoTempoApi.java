package com.example.previsaodotempo.retrofit;

import com.example.previsaodotempo.model.PrevisaoDoDia;
import com.example.previsaodotempo.model.PrevisaoDoTempo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PrevisaoDoTempoApi {


    @GET("/weather?array_limit=8&fields=only_results,temp,date,Florianopolis,forecast,max,min,date, weekday&key=b6411d18")
    Call<PrevisaoDoDia> getPrevisaoDoTempo();


}

