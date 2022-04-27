package com.example.lovecalculator03.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.lovecalculator03.model.HistoryModel;

import java.util.List;

@Dao
public interface HistoryDao {

    @Insert
    void insert(HistoryModel historyModel);

    @Query("SELECT * FROM historymodel")
    LiveData<List<HistoryModel>> getHistory();

    @Query("SELECT * FROM historymodel WHERE firstName=:firstNameInput")
    LiveData<List<HistoryModel>> getBatmanHistory(String firstNameInput);

}
