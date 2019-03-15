package com.pulkit.newsapp.entity;

import com.pulkit.newsapp.model.NewsArticle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class EntityUnitTest {

    @Test
    public void testId() {
        NewsArticle newsArticle = new NewsArticle();
        newsArticle.setId(1000);
        assertEquals(newsArticle.getId(),1000);
    }

    @Test
    public void testTitle(){
        NewsArticle newsArticle = new NewsArticle();
        newsArticle.setTitle("test");
        assertEquals(newsArticle.getTitle(),"test");
    }

    @Test
    public void testAuthor(){
        NewsArticle newsArticle = new NewsArticle();
        newsArticle.setAuthor("test");
        assertEquals(newsArticle.getAuthor(),"test");
    }

    @Test
    public void testContent(){
        NewsArticle newsArticle = new NewsArticle();
        newsArticle.setContent("test");
        assertEquals(newsArticle.getContent(),"test");
    }

    @Test
    public void testPublishDate(){
        NewsArticle newsArticle = new NewsArticle();
        newsArticle.setPublishedAt("test");
        assertEquals(newsArticle.getPublishedAt(),"test");
    }

    @Test
    public void testDescription(){
        NewsArticle newsArticle = new NewsArticle();
        newsArticle.setDescription("test");
        assertEquals(newsArticle.getDescription(),"test");
    }

    @Test
    public void testUrl(){
        NewsArticle newsArticle = new NewsArticle();
        newsArticle.setUrl("test");
        assertEquals(newsArticle.getUrl(),"test");
    }

    @Test
    public void testImageUrl(){
        NewsArticle newsArticle = new NewsArticle();
        newsArticle.setImageUrl("test");
        assertEquals(newsArticle.getImageUrl(),"test");
    }

}
