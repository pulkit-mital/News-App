package com.pulkit.newsapp.dependencyinjection.module;

import com.pulkit.newsapp.scope.ViewModelKey;
import com.pulkit.newsapp.viewmodel.NewsViewModel;
import com.pulkit.newsapp.viewmodel.NewsViewModelFactory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel.class)
    abstract ViewModel bindNewsViewModel(NewsViewModel newsViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(NewsViewModelFactory newsViewModelFactory);
}
