package com.pulkit.newsapp.dependencyinjection.module;

import com.pulkit.newsapp.activities.NewsActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = ViewModelModule.class)
    abstract NewsActivity contributesNewsActivity();
}
