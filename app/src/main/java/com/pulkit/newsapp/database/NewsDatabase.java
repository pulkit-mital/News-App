package com.pulkit.newsapp.database;

import com.pulkit.newsapp.model.NewsArticle;

import androidx.room.Database;

/**
 * Room Database to store various entities or tables in the database
 * has instance of dao to operate CRUD instruction
 */
@Database(entities = {NewsArticle.class}, version = 1)
public abstract class NewsDatabase {
    public abstract NewsArticleDao newsArticleDao();
}
