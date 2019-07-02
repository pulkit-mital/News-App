package com.pulkit.newsapp.service;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.pulkit.newsapp.utils.Constants.NEWS_API_URL;

public class NetworkUtil {

    private static Retrofit retrofit;

    public static Retrofit getRetrofitClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(NEWS_API_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

