package com.example.previsaodotempo.model;


import com.google.gson.annotations.SerializedName;

public class PrevisaoDaSemana {

    @SerializedName("date")
    private String date;
    //@SerializedName("weekday")
    //private String weekday;
    @SerializedName("max")
    private Integer max;
    @SerializedName("min")
    private Integer min;
//    @SerializedName("description")
//    private String description;
//    @SerializedName("condition")
//    private String condition;

    public PrevisaoDaSemana() {
    }

    public PrevisaoDaSemana(String date, Integer max, Integer min) {
        this.date = date;
        this.max = max;
        this.min = min;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }
}