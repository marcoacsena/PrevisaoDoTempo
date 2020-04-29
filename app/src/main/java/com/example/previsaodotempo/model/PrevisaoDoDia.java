package com.example.previsaodotempo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PrevisaoDoDia {

    @SerializedName("temp")
    private Integer temp;
    @SerializedName("date")
    private String date;
//    @SerializedName("time")
//    private String time;
//    @SerializedName("condition_code")
//    private String condition_code;
//    @SerializedName("description")
//    private String description;
//    @SerializedName("currently")
//    private String currently;
//    @SerializedName("cid")
//    private String cid;
//    @SerializedName("city")
//    private String city;
//    @SerializedName("img_id")
//    private String img_id;
//    @SerializedName("humidity")
//    private Integer humidity;
//    @SerializedName("wind_speedy")
//    private String wind_speedy;
//    @SerializedName("sunrise")
//    private String sunrise;
//    @SerializedName("sunset")
//    private String sunset;
//    @SerializedName("condition_slug")
//    private String condition_slug;
    @SerializedName("city_name")
    private String cityName;

    @SerializedName("forecast")
    private List <PrevisaoDaSemana> previsaoDaSemana;

//    public PrevisaoDoDia() {
//    }
//
//    public PrevisaoDoDia(Integer temp, String date, String city_name, List<PrevisaoDaSemana> previsaoDaSemana) {
//        this.temp = temp;
//        this.date = date;
//        this.city_name = city_name;
//        this.previsaoDaSemana = previsaoDaSemana;
//    }


    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<PrevisaoDaSemana> getPrevisaoDaSemana() {
        return previsaoDaSemana;
    }

    public void setPrevisaoDaSemana(List<PrevisaoDaSemana> previsaoDaSemana) {
        this.previsaoDaSemana = previsaoDaSemana;
    }
}
