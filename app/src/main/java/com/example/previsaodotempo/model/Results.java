package com.example.previsaodotempo.model;

import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("temp")
    private Integer temp;
    @SerializedName("date")
    private String date;
    @SerializedName("time")
    private String time;
    @SerializedName("condition_code")
    private String condition_code;
    @SerializedName("description")
    private String description;
    @SerializedName("currently")
    private String currently;
    @SerializedName("cid")
    private String cid;
    @SerializedName("city")
    private String city;
    @SerializedName("img_id")
    private String img_id;
    @SerializedName("humidity")
    private Integer humidity;
    @SerializedName("wind_speedy")
    private String wind_speedy;
    @SerializedName("sunrise")
    private String sunrise;
    @SerializedName("sunset")
    private String sunset;
    @SerializedName("condition_slug")
    private String condition_slug;
    @SerializedName("city_name")
    private String city_name;

    private Forecast forecast;


}
