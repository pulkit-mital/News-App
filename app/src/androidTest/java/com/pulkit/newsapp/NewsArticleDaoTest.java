package com.pulkit.newsapp;

import com.pulkit.newsapp.database.NewsDatabase;
import com.pulkit.newsapp.model.NewsArticle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Room;
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class NewsArticleDaoTest {

    private NewsDatabase newsDatabase;

    @Before
    public void init(){
        newsDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), NewsDatabase.class).build();
    }

    @After
    public void uninit(){
        newsDatabase.close();
    }

    @Test
    public void testLoadArticles(){
        List<NewsArticle> articles = new ArrayList<>();
        NewsArticle newsArticle = new NewsArticle();
        newsArticle.setImageUrl("test");
        newsArticle.setUrl("test");
        newsArticle.setDescription("test");
        newsArticle.setPublishedAt("test");
        newsArticle.setContent("test");
        newsArticle.setAuthor("test");
        newsArticle.setTitle("test");
        newsArticle.setId(1000);

        articles.add(newsArticle);
        newsDatabase.newsArticleDao().insertNewsArticles(articles);
        LiveData<List<NewsArticle>> liveData = newsDatabase.newsArticleDao().getNewsArticles();
        assertNotNull(liveData);
    }


}
