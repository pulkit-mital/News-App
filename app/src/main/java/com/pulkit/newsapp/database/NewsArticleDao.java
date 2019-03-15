package com.pulkit.newsapp.database;

import com.pulkit.newsapp.model.NewsArticle;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.REPLACE;

/**
 * Data Access object to do various CRUD operation
 * in the NEWS ARTICLES TABLE
 */
@Dao
public interface NewsArticleDao {

    @Query("SELECT * FROM news_article_table LIMIT 20")
    LiveData<List<NewsArticle>> getNewsArticles();

    @Insert(onConflict = REPLACE)
    void insertNewsArticles(List<NewsArticle> newsArticles);
}
