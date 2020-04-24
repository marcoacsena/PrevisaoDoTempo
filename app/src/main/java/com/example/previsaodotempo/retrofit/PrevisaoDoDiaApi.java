package com.example.previsaodotempo.retrofit;

import com.example.previsaodotempo.model.PrevisaoDoDia;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PrevisaoDoDiaApi {

    //@GET("weather?key=3ec0c5f0&city_name={nomeDaCidade}")
    //Call<PrevisaoDoTempo> getPrevisaoDoTempo(@Path("nomeDaCidade") String nomeDaCidade);

    @GET("?array_limit=8&fields=only_results,temp,Sao%20Paulo,SP,forecast,max,min,date,weekday&key=3ec0c5f0")
    Call<PrevisaoDoDia> getPrevisaoDoDia( );



//    @GET("weather?key=3ec0c5f0/{city_name}") @Query("nomeDaCidade") String nomeDaCidade
//    Call<PrevisaoDoTempo> getPrevisaoDoTempo (@Path("city_name") String nomeCidade);
}

