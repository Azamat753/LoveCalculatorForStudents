package com.example.lovecalculator03.model;

import com.google.gson.annotations.SerializedName;

public class LoveModel {
    @SerializedName("fname")
    String firstName;
    @SerializedName("sname")
    String secondName;
    String percentage;
    String result;

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPercentage() {
        return percentage;
    }

    public String getResult() {
        return result;
    }
}
