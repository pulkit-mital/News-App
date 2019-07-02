package com.pulkit.newsapp.viewmodel;


import com.pulkit.newsapp.model.NewsArticle;
import com.pulkit.newsapp.respository.NewsRepository;

import java.util.List;


import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NewsPresenter implements NewsContract.Presenter{

    private NewsContract.View newsView;
    private Subscription newsSubscription;
    private NewsRepository newsRepository;


    public NewsPresenter(NewsRepository newsRepository, NewsContract.View view){
      this.newsRepository = newsRepository;
      this.newsView = view;
    }

    @Override
    public void getNews() {
        newsSubscription = newsRepository.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<NewsArticle>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<NewsArticle> news) {
                        newsView.showData(news);
                    }
                });
    }
}
