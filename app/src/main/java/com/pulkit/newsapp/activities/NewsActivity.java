package com.pulkit.newsapp.activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.pulkit.newsapp.R;
import com.pulkit.newsapp.adapters.NewsArticleRecyclerAdapter;
import com.pulkit.newsapp.databinding.ActivityNewsBinding;
import com.pulkit.newsapp.listener.ClickListener;
import com.pulkit.newsapp.model.NewsArticle;
import com.pulkit.newsapp.utils.NetworkUtil;
import com.pulkit.newsapp.viewmodel.NewsViewModel;
import com.pulkit.newsapp.viewmodel.NewsViewModelFactory;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.AndroidInjection;

import static com.pulkit.newsapp.utils.Constants.EXTRA_TITLE;
import static com.pulkit.newsapp.utils.Constants.EXTRA_URL;

public class NewsActivity extends AppCompatActivity implements ClickListener {

    ActivityNewsBinding activityNewsBinding;

    @Inject
    NewsViewModelFactory newsViewModelFactory;

    @Inject
    NewsArticleRecyclerAdapter newsArticleRecyclerAdapter;

    NewsViewModel newsViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        activityNewsBinding = DataBindingUtil.setContentView(this, R.layout.activity_news);
        initializeToolbar();
        initializeViewModel();
        initializeView();


    }

    private void initializeToolbar() {
        activityNewsBinding.layoutToolBar.toolbar.setTitle(getResources().getString(R.string.app_name));
    }

    private void initializeViewModel() {
        newsViewModel = ViewModelProviders.of(this, newsViewModelFactory).get(NewsViewModel.class);
    }

    private void initializeView() {
        activityNewsBinding.setNewsViewModel(newsViewModel);
        activityNewsBinding.setNewsArticleRecyclerAdapter(newsArticleRecyclerAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        initializeObservers();
    }

    private void initializeObservers() {
        newsViewModel.getNewsArticles().observe(this, new Observer<List<NewsArticle>>() {
            @Override
            public void onChanged(List<NewsArticle> newsArticles) {
                newsArticleRecyclerAdapter.setNewsArticles(newsArticles);

            }
        });

        newsViewModel.getArticles().observe(this, new Observer<List<NewsArticle>>() {
            @Override
            public void onChanged(List<NewsArticle> newsArticles) {
                newsArticleRecyclerAdapter.setNewsArticles(newsArticles);

            }
        });

        newsViewModel.getErrorMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Snackbar.make(activityNewsBinding.getRoot(), s, Snackbar.LENGTH_SHORT).show();
                if (NetworkUtil.isNetworkConnected(getApplicationContext())) {
                    newsViewModel.getArticles();
                }
            }
        });

        newsViewModel.getIsProgressVisible().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer aBoolean) {
                activityNewsBinding.progressBar.setVisibility(aBoolean);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (newsViewModel != null) {
            newsViewModel.getNewsArticles().removeObservers(this);
            newsViewModel.getArticles().removeObservers(this);
            newsViewModel.getErrorMessage().removeObservers(this);
            newsViewModel.getIsProgressVisible().removeObservers(this);
        }
    }

    @Override
    public void launchNewsDetailActivity(String url, String title) {
        Intent intent = new Intent(this, NewsDetailActivity.class);
        intent.putExtra(EXTRA_URL, url);
        intent.putExtra(EXTRA_TITLE, title);
        startActivity(intent);
    }
}
