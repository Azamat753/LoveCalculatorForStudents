package com.example.lovecalculator03;

import android.app.Application;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.lovecalculator03.room.AppDataBase;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class App extends Application {

    public static AppDataBase appDataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        appDataBase = Room.databaseBuilder(getApplicationContext(),
                AppDataBase.class, "love-data").allowMainThreadQueries().build();
    }
}
