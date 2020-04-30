package com.example.previsaodotempo.model;

import com.google.gson.annotations.SerializedName;

public class PrevisaoDoTempo {
    @SerializedName("by")
    private String by;
    @SerializedName("valid_key")
    private Boolean validKey;
//    @SerializedName("execution_time")
//    private Double executionTime;
//    @SerializedName("from_cache")
//    private Boolean fromCache;

    @SerializedName("results")
    private PrevisaoDoDia previsaoDoDia;
//
//    public PrevisaoDoTempo() {
//    }
//
//    public PrevisaoDoTempo(String by, Boolean validKey, PrevisaoDoDia previsaoDoDia) {
//        this.by = by;
//        this.validKey = validKey;
//        this.previsaoDoDia = previsaoDoDia;
//    }


    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public Boolean getValidKey() {
        return validKey;
    }

    public void setValidKey(Boolean validKey) {
        this.validKey = validKey;
    }

    public PrevisaoDoDia getPrevisaoDoDia() {
        return previsaoDoDia;
    }

    public void setPrevisaoDoDia(PrevisaoDoDia previsaoDoDia) {
        this.previsaoDoDia = previsaoDoDia;
    }
}
