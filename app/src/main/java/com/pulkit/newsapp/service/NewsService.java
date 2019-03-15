package com.pulkit.newsapp.service;

import com.pulkit.newsapp.model.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsService {

    @GET("top-headlines")
    Call<News> getNews(@Query("apiKey") String apiKey , @Query("country") String country);
}
