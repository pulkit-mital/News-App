package com.pulkit.newsapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pulkit.newsapp.BR;
import com.pulkit.newsapp.R;
import com.pulkit.newsapp.activities.NewsActivity;
import com.pulkit.newsapp.databinding.ItemNewsBinding;
import com.pulkit.newsapp.model.NewsArticle;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class NewsArticleRecyclerAdapter extends RecyclerView.Adapter<NewsArticleRecyclerAdapter.ViewHolder> {

    private List<NewsArticle> newsArticles;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemNewsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_news, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setVariable(BR.newsArticle, newsArticles.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return newsArticles == null ? 0 : newsArticles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        final ItemNewsBinding binding;

        public ViewHolder(ItemNewsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void setNewsArticles(List<NewsArticle> newsArticles){
        this.newsArticles = newsArticles;
        notifyDataSetChanged();
    }
}
