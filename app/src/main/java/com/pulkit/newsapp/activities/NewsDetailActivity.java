package com.pulkit.newsapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.pulkit.newsapp.R;
import com.pulkit.newsapp.databinding.ActivityNewsDetailBinding;
import com.pulkit.newsapp.utils.CustomWebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import static com.pulkit.newsapp.utils.Constants.EXTRA_TITLE;
import static com.pulkit.newsapp.utils.Constants.EXTRA_URL;

public class NewsDetailActivity extends AppCompatActivity {

    private ActivityNewsDetailBinding activityNewsDetailBinding;
    private String title;
    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityNewsDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_news_detail);
        initializeDataFromBundle();
        initializeToolbar();
        initializeWebView();
    }

    private void initializeDataFromBundle() {
        Intent intent = getIntent();
        if (intent != null) {
            title = intent.getStringExtra(EXTRA_TITLE);
            url = intent.getStringExtra(EXTRA_URL);
        }
    }

    private void initializeToolbar() {
        activityNewsDetailBinding.layoutToolBar.toolbar.setTitle(title);
        setSupportActionBar(activityNewsDetailBinding.layoutToolBar.toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initializeWebView() {
        activityNewsDetailBinding.setCustomWebViewClient(new CustomWebViewClient(activityNewsDetailBinding.progressBar));
        activityNewsDetailBinding.setUrl(url);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }
}
