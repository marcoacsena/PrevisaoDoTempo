package com.example.previsaodotempo.retrofit;

import com.example.previsaodotempo.model.PrevisaoDoDia;
import com.example.previsaodotempo.model.PrevisaoDoTempo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PrevisaoDoTempoApi {


    @GET("/weather?key=b6411d18&city_name=Brasilia,DF")
    Call<PrevisaoDoTempo> getPrevisaoDoTempo();


}

