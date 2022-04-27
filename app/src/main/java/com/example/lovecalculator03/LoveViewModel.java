package com.example.lovecalculator03;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lovecalculator03.model.LoveModel;

import javax.inject.Inject;

import dagger.hilt.android.HiltAndroidApp;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class LoveViewModel extends ViewModel {

    LoveRepository loveRepository;

    @Inject
    public LoveViewModel(LoveRepository loveRepository) {
        this.loveRepository = loveRepository;
    }

    public LiveData<LoveModel> getLoveModelLiveData(String male, String female) {
        return loveRepository.getDataFromApi(male, female);
    }

}
