package com.pulkit.newsapp.utils;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.pulkit.newsapp.R;
import com.squareup.picasso.Picasso;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;

public class BindingUtils {

    @BindingAdapter({"url"})
    public static void setImageUrl(AppCompatImageView appCompatImageView, String url) {

        Picasso.get().load(url).fit().error(R.drawable.ic_placeholder).placeholder(R.drawable.ic_placeholder).into(appCompatImageView);
    }

    @BindingAdapter({"authorText"})
    public static void setAuthorText(TextView textView, String author) {
        if (author == null || author.isEmpty()) {
            textView.setVisibility(View.GONE);
        } else {
            SpannableString authorText = new SpannableString(String.format(textView.getContext().getResources().getString(R.string.sf_author), textView.getContext().getResources().getString(R.string.author_title), author));
            authorText.setSpan(new StyleSpan(Typeface.BOLD), 0, textView.getContext().getResources().getString(R.string.author_title).length() - 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            textView.setText(authorText);
        }
    }

    @BindingAdapter({"publishText"})
    public static void setPaublishedDate(TextView textView, String date) {

        if (date == null || date.isEmpty()) {
            textView.setVisibility(View.GONE);
        } else {
            SpannableString authorText = new SpannableString(String.format(textView.getContext().getResources().getString(R.string.sf_author), textView.getContext().getResources().getString(R.string.publish_title), DateUtil.getInstance().formatDate(date)));
            authorText.setSpan(new StyleSpan(Typeface.BOLD), 0, textView.getContext().getResources().getString(R.string.publish_title).length() - 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            textView.setText(authorText);
        }
    }

    @BindingAdapter({"webUrl","webViewClient"})
    public static void loadWebPage(WebView webView, String url, CustomWebViewClient customWebViewClient) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(customWebViewClient);
        webView.loadUrl(url);

    }
}
