package com.pulkit.newsapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {

    private String status;
    private int totalResults;

    @SerializedName("articles")
    private List<NewsArticle> newsArticleList;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<NewsArticle> getNewsArticleList() {
        return newsArticleList;
    }

    public void setNewsArticleList(List<NewsArticle> newsArticleList) {
        this.newsArticleList = newsArticleList;
    }
}
