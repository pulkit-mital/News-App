package com.pulkit.newsapp.respository;

import com.pulkit.newsapp.NewsApplication;
import com.pulkit.newsapp.database.NewsArticleDao;
import com.pulkit.newsapp.model.News;
import com.pulkit.newsapp.model.NewsArticle;
import com.pulkit.newsapp.service.NewsService;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.lifecycle.LiveData;
import retrofit2.Call;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;

import static com.pulkit.newsapp.utils.Constants.API_KEY;
import static com.pulkit.newsapp.utils.Constants.COUNTRY;
import static com.pulkit.newsapp.utils.NetworkUtil.isNetworkConnected;

/**
 * The class will provide access to web service to fetch data from network
 * as well as room database to get data when network connection is not there
 */
public class NewsRepository {

    private NewsArticleDao newsArticleDao;
    private NewsService newsService;
    private NewsApplication newsApplication;

    public NewsRepository(NewsArticleDao newsArticleDao, NewsService newsService, NewsApplication newsApplication) {
        this.newsArticleDao = newsArticleDao;
        this.newsService = newsService;
        this.newsApplication = newsApplication;
    }


    public Observable<List<NewsArticle>> getNews() {
        return Observable.create(new Observable.OnSubscribe<List<NewsArticle>>() {
            @Override
            public void call(Subscriber<? super List<NewsArticle>> subscriber) {
                if (isNetworkConnected(newsApplication.getApplicationContext())) {

                    Call<News> call = newsService.getNews(API_KEY, COUNTRY);
                    try {

                        Response<News> response = call.execute();
                        if (response.isSuccessful()) {
                            newsArticleDao.insertNewsArticles(((News) response.body()).getNewsArticleList());
                            subscriber.onNext(((News) response.body()).getNewsArticleList());
                        } else {
                            subscriber.onError(new Exception(response.errorBody().string()));
                        }

                    } catch (IOException e) {
                        subscriber.onError(e);
                    }
                } else {
                    subscriber.onError(new Exception("No Internet Connection"));
                }
            }
        });
    }

    public LiveData<List<NewsArticle>> loadArticles() {
        return newsArticleDao.getNewsArticles();
    }
}
