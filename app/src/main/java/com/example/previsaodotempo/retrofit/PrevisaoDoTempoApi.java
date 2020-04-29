package com.example.previsaodotempo.retrofit;

import com.example.previsaodotempo.model.PrevisaoDoDia;
import com.example.previsaodotempo.model.PrevisaoDoTempo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PrevisaoDoTempoApi {

    //@GET("weather?key=3ec0c5f0&city_name={nomeDaCidade}")
    //Call<PrevisaoDoTempo> getPrevisaoDoTempo(@Path("nomeDaCidade") String nomeDaCidade);

    @GET("/weather?array_limit=8&fields=only_results,temp,date,Florianopolis,forecast,max,min,date, weekday&key=b6411d18")
    Call<PrevisaoDoDia> getPrevisaoDoTempo();

    //"weather?array_limit=2&fields=only_results,temp,Sao Paulo,forecast,max,min,date&key=b6411d18"

//"?array_limit=2&fields=only_results,temp,city_name,forecast,max,min,date&key=909760a2"

//    @GET("weather?key=3ec0c5f0/{city_name}") @Query("nomeDaCidade") String nomeDaCidade
//    Call<PrevisaoDoTempo> getPrevisaoDoTempo (@Path("city_name") String nomeCidade);
}

