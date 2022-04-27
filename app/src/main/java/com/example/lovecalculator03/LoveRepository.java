package com.example.lovecalculator03;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.lovecalculator03.model.LoveModel;
import com.example.lovecalculator03.network.LoveApi;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoveRepository {

    private LoveApi loveApi;

    @Inject
    public LoveRepository(LoveApi loveApi) {
        this.loveApi = loveApi;
    }

    public MutableLiveData<LoveModel> getDataFromApi(String male, String femaleMale) {
        MutableLiveData<LoveModel> model = new MutableLiveData<>();

        loveApi.getLove(male, femaleMale, "love-calculator.p.rapidapi.com",
                "78bb8ecc8dmsha71f7db1db6c66cp1338f5jsn2ae3a25d70d2")
                .enqueue(new Callback<LoveModel>() {
                    @Override
                    public void onResponse(Call<LoveModel> call, Response<LoveModel> response) {
                        if (response.isSuccessful()) {
                            model.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<LoveModel> call, Throwable t) {
                        Log.e("ololo", t.getMessage());
                    }
                });

        return model;
    }
}
