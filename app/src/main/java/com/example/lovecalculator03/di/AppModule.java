package com.example.lovecalculator03.di;

import com.example.lovecalculator03.LoveRepository;
import com.example.lovecalculator03.network.LoveApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public LoveApi provideLoveApi() {
        return new Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(LoveApi.class);
    }

    @Provides
    public LoveRepository provideRepository() {
        return new LoveRepository(provideLoveApi());
    }

}
