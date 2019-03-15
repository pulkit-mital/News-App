package com.pulkit.newsapp.api;

import com.pulkit.newsapp.service.NewsService;
import com.pulkit.newsapp.utils.Constants;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.pulkit.newsapp.utils.Constants.API_KEY;
import static com.pulkit.newsapp.utils.Constants.CONNECT_TIMEOUT;
import static com.pulkit.newsapp.utils.Constants.COUNTRY;
import static com.pulkit.newsapp.utils.Constants.READ_TIMEOUT;
import static com.pulkit.newsapp.utils.Constants.WRITE_TIMEOUT;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ApiServiceUnitTest {

    private NewsService newsService;

    @Before
    public void createService() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

        newsService = new Retrofit.Builder()
                .baseUrl(Constants.NEWS_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build()
                .create(NewsService.class);
    }

    @Test
    public void getNews() {
        try {
            Response response = newsService.getNews(API_KEY, COUNTRY).execute();
            assertEquals(response.code(), 200);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
