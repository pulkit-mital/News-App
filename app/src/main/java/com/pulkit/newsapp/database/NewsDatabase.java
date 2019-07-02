package com.pulkit.newsapp.database;

import android.content.Context;

import com.pulkit.newsapp.model.NewsArticle;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import static com.pulkit.newsapp.utils.Constants.DATABASE_NAME;

/**
 * Room Database to store various entities or tables in the database
 * has instance of dao to operate CRUD instruction
 */
@Database(entities = {NewsArticle.class}, version = 1)
public abstract class NewsDatabase extends RoomDatabase {
    private static NewsDatabase INSTANCE;

    public abstract NewsArticleDao newsArticleDao();

    public static NewsDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (NewsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NewsDatabase.class, DATABASE_NAME)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }

        return INSTANCE;
    }


}
