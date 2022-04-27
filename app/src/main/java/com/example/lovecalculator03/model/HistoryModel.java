package com.example.lovecalculator03.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class HistoryModel {
    @PrimaryKey(autoGenerate = true)
    int id;
    String firstName;
    String secondName;
    String percentage;
    String result;

    public HistoryModel(String firstName, String secondName, String percentage, String result) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.percentage = percentage;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
