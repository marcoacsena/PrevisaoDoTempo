package com.example.previsaodotempo.model;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

public class PrevisaoDaSemana {

    @SerializedName("date")
    private String date;
    @SerializedName("weekday")
    private String weekday;
    @SerializedName("max")
    private Integer max;
    @SerializedName("min")
    private Integer min;
//    @SerializedName("description")
//    private String description;
//    @SerializedName("condition")
//    private String condition;


//    public PrevisaoDaSemana() {
//    }
//
    public PrevisaoDaSemana(String date, String weekday, Integer max, Integer min) {
        this.date = date;
        this.weekday = weekday;
        this.max = max;
        this.min = min;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
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

//       @Override
//    public int compareTo(PrevisaoDaSemana previsaoDaSemana) {
//
//        if(previsaoDaSemana.getDate() == this.date){
//            return 0;
//        }else if(previsaoDaSemana.getDate() > this.date){
//            return 1;
//        }else
//
//        return -1;
//    }

    public static class DateComparator implements Comparator<PrevisaoDaSemana>{


        @Override
        public int compare(PrevisaoDaSemana previsaoDaSemana1, PrevisaoDaSemana previsaoDaSemana2) {
            return previsaoDaSemana2.getDate().compareTo(previsaoDaSemana1.getDate());
        }
    }


}