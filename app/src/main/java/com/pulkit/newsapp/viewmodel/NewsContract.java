package com.pulkit.newsapp.viewmodel;


import com.pulkit.newsapp.model.NewsArticle;

import java.util.List;

public interface NewsContract {

    interface View {

        void showData(List<NewsArticle> news);
    }

    interface Presenter {
        void getNews();
    }
}
