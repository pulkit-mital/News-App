package com.pulkit.newsapp.navigator;

import android.content.Context;
import android.content.Intent;

import com.pulkit.newsapp.activities.NewsDetailActivity;

import static com.pulkit.newsapp.utils.Constants.EXTRA_TITLE;
import static com.pulkit.newsapp.utils.Constants.EXTRA_URL;

public class Navigator {

    public static void openNewsDetailActivity(Context context, String url, String title){
        Intent intent = new Intent(context, NewsDetailActivity.class);
        intent.putExtra(EXTRA_URL, url);
        intent.putExtra(EXTRA_TITLE, title);
        context.startActivity(intent);
    }
}
