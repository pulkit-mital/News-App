package com.pulkit.newsapp.dependencyinjection.module;

import android.content.Context;

import com.pulkit.newsapp.NewsApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Singleton
    @Provides
    Context provideApplicationContext(NewsApplication newsApplication) {
        return newsApplication.getApplicationContext();
    }
}
