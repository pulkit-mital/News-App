package com.pulkit.newsapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pulkit.newsapp.BR;
import com.pulkit.newsapp.R;
import com.pulkit.newsapp.activities.NewsActivity;
import com.pulkit.newsapp.databinding.ItemNewsBinding;
import com.pulkit.newsapp.listener.ClickListener;
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
        return new ViewHolder(binding, (NewsActivity) parent.getContext());
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final ItemNewsBinding binding;
        private ClickListener clickListener;

        public ViewHolder(ItemNewsBinding binding, ClickListener clickListener) {
            super(binding.getRoot());
            this.binding = binding;
            this.clickListener = clickListener;
            binding.itemCardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.launchNewsDetailActivity(newsArticles.get(getAdapterPosition()).getUrl(), newsArticles.get(getAdapterPosition()).getTitle());

        }
    }

    public void setNewsArticles(List<NewsArticle> newsArticles){
        this.newsArticles = newsArticles;
        notifyDataSetChanged();
    }
}
