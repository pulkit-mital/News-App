package com.pulkit.newsapp.dependencyinjection.module;

import com.pulkit.newsapp.adapters.NewsArticleRecyclerAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RecyclerAdapterModule {

    @Provides
    @Singleton
    public NewsArticleRecyclerAdapter provideNewsArticleRecyclerAdapter() {
        return new NewsArticleRecyclerAdapter();
    }

}
