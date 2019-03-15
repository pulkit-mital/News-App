package com.pulkit.newsapp;

import android.view.View;

import com.pulkit.newsapp.activities.NewsActivity;
import com.pulkit.newsapp.adapters.NewsArticleRecyclerAdapter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class NewsActivityTest {

    @Rule
    public ActivityTestRule<NewsActivity> rule = new ActivityTestRule<>(NewsActivity.class);

    @Test
    public void ensureListViewIsPresent() throws Exception {
        NewsActivity activity = rule.getActivity();
        View viewById = activity.findViewById(R.id.news_recycler_view);
        assertThat(viewById, notNullValue());
        assertThat(viewById, instanceOf(RecyclerView.class));
        RecyclerView recyclerView = (RecyclerView) viewById;
        NewsArticleRecyclerAdapter adapter = (NewsArticleRecyclerAdapter) recyclerView.getAdapter();
        assertThat(adapter, instanceOf(RecyclerView.Adapter.class));
        assertThat(adapter.getItemCount(), greaterThan(5));

    }
}
