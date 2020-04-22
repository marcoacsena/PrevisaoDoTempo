package com.example.previsaodotempo.model;


import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("date")
    private String date;
    @SerializedName("weekday")
    private String weekday;
    @SerializedName("max")
    private Integer max;
    @SerializedName("min")
    private Integer min;
    @SerializedName("description")
    private String description;
    @SerializedName("condition")
    private String condition;

    public Forecast() {
    }

    public Forecast(String date, String weekday, Integer max, Integer min, String description, String condition) {
        this.date = date;
        this.weekday = weekday;
        this.max = max;
        this.min = min;
        this.description = description;
        this.condition = condition;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}