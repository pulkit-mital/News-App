package com.pulkit.newsapp.dependencyinjection.module;

import android.content.Context;

import com.pulkit.newsapp.database.NewsArticleDao;
import com.pulkit.newsapp.database.NewsDatabase;
import com.pulkit.newsapp.service.NewsService;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

import static com.pulkit.newsapp.utils.Constants.DATABASE_NAME;

@Module(includes = NetworkModule.class)
public class NetworkServiceModule {

    @Provides
    @Singleton
    NewsService provideNewsService(Retrofit retrofit) {
        return retrofit.create(NewsService.class);
    }

    @Provides
    @Singleton
    NewsDatabase provideNewsDatabase(Context context) {
        return Room.databaseBuilder(context, NewsDatabase.class, DATABASE_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();
    }

    @Provides
    @Singleton
    NewsArticleDao provideNewsArticleDao(NewsDatabase newsDatabase) {
        return newsDatabase.newsArticleDao();
    }
}
