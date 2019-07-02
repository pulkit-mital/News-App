package com.pulkit.newsapp.activities;
import android.os.Bundle;

import com.pulkit.newsapp.R;
import com.pulkit.newsapp.adapters.NewsArticleRecyclerAdapter;
import com.pulkit.newsapp.databinding.ActivityNewsBinding;
import com.pulkit.newsapp.listener.ClickListener;
import com.pulkit.newsapp.navigator.Navigator;
import com.pulkit.newsapp.viewmodel.NewsViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

public class NewsActivity extends AppCompatActivity implements ClickListener {

    ActivityNewsBinding activityNewsBinding;
    NewsArticleRecyclerAdapter newsArticleRecyclerAdapter;
    NewsViewModel newsViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityNewsBinding = DataBindingUtil.setContentView(this, R.layout.activity_news);
        activityNewsBinding.setLifecycleOwner(this);
        initializeToolbar();
        initializeViewModel();
        initializeView();


    }

    private void initializeToolbar() {
        activityNewsBinding.layoutToolBar.toolbar.setTitle(getResources().getString(R.string.app_name));
    }

    private void initializeViewModel() {
        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
    }

    private void initializeView() {
        activityNewsBinding.setNewsViewModel(newsViewModel);
        newsArticleRecyclerAdapter = new NewsArticleRecyclerAdapter();
        activityNewsBinding.setNewsArticleRecyclerAdapter(newsArticleRecyclerAdapter);
    }

    @Override
    public void launchNewsDetailActivity(String url, String title) {
        Navigator.openNewsDetailActivity(this, url, title);
    }
}
