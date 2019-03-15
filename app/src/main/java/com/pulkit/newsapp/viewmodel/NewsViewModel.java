package com.pulkit.newsapp.viewmodel;

import com.pulkit.newsapp.respository.NewsRepository;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;

/**
 * The class help us to fetch data using repository and will update UI
 * as it contains live data and UI is observing change in the data
 */
public class NewsViewModel extends ViewModel {

    private NewsRepository newsRepository;

    @Inject
    public NewsViewModel(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }
}
