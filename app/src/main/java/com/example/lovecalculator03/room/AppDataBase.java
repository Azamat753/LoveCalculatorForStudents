package com.example.lovecalculator03.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.lovecalculator03.model.HistoryModel;

@Database(entities = {HistoryModel.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract HistoryDao historyDao();
}
