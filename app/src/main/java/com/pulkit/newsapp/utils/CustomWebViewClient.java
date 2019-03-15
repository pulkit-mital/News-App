package com.pulkit.newsapp.utils;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class CustomWebViewClient extends WebViewClient {

    private ProgressBar progressBar;

    public CustomWebViewClient(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        if (progressBar != null && progressBar.isShown()) {
            progressBar.setVisibility(View.GONE);
        }
    }


}
