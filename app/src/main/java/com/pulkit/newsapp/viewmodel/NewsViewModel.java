package com.pulkit.newsapp.viewmodel;

import android.app.Application;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.pulkit.newsapp.NewsApplication;
import com.pulkit.newsapp.database.NewsDatabase;
import com.pulkit.newsapp.model.NewsArticle;
import com.pulkit.newsapp.respository.NewsRepository;
import com.pulkit.newsapp.service.NetworkUtil;
import com.pulkit.newsapp.service.NewsService;

import java.util.List;


import androidx.annotation.NonNull;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
;

/**
 * The class help us to fetch data using repository and will update UI
 * as it contains live data and UI is observing change in the data
 */
public class NewsViewModel extends AndroidViewModel implements NewsContract.View {

    private NewsPresenter newsPresenter;
    private MutableLiveData<List<NewsArticle>> newsArticles = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private MutableLiveData<Integer> isProgressVisible = new MutableLiveData<>();
    private NewsApplication newsApplication;

    public NewsViewModel(@NonNull Application application) {
        super(application);
        this.newsApplication = (NewsApplication) application;
        initializePresenter();
    }

    private void initializePresenter() {
        NewsDatabase newsDatabase = NewsDatabase.getDatabase(newsApplication);
        this.newsPresenter = new NewsPresenter(new NewsRepository(newsDatabase.newsArticleDao(), NetworkUtil.getRetrofitClient().create(NewsService.class), newsApplication), this);
        newsPresenter.getNews();
    }


    public MutableLiveData<List<NewsArticle>> getNewsArticles() {
        return newsArticles;
    }

    public MutableLiveData<String> getErrorMessage() {
        return errorMessage;
    }


    public MutableLiveData<Integer> getIsProgressVisible() {
        return isProgressVisible;
    }


    @Override
    protected void onCleared() {
        super.onCleared();

    }

    @Override
    public void showData(List<NewsArticle> news) {
        newsArticles.postValue(news);
        isProgressVisible.postValue(View.GONE);
    }
}

