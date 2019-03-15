package com.pulkit.newsapp.viewmodel;

import android.view.View;

import com.pulkit.newsapp.model.NewsArticle;
import com.pulkit.newsapp.respository.NewsRepository;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * The class help us to fetch data using repository and will update UI
 * as it contains live data and UI is observing change in the data
 */
public class NewsViewModel extends ViewModel {

    private NewsRepository newsRepository;
    private Subscription newsSubscription;
    private MutableLiveData<List<NewsArticle>> newsArticles = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private MutableLiveData<Integer> isProgressVisible = new MutableLiveData<>();

    @Inject
    public NewsViewModel(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public void getNews() {

        isProgressVisible.setValue(View.VISIBLE);
        newsSubscription = newsRepository.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<NewsArticle>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        errorMessage.setValue(e.getMessage());
                        isProgressVisible.setValue(View.GONE);
                    }

                    @Override
                    public void onNext(List<NewsArticle> news) {
                        newsArticles.setValue(news);
                        isProgressVisible.setValue(View.GONE);
                    }
                });
    }

    public LiveData<List<NewsArticle>> getArticles() {
        return newsRepository.loadArticles();
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
        if (newsSubscription != null && !newsSubscription.isUnsubscribed()) {
            newsSubscription.unsubscribe();
        }
    }
}

