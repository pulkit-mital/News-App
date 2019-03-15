package com.pulkit.newsapp.dependencyinjection.component;

import com.pulkit.newsapp.NewsApplication;
import com.pulkit.newsapp.dependencyinjection.module.ActivityBuilderModule;
import com.pulkit.newsapp.dependencyinjection.module.AppModule;
import com.pulkit.newsapp.dependencyinjection.module.NetworkServiceModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AppModule.class, NetworkServiceModule.class, AndroidSupportInjectionModule.class, ActivityBuilderModule.class})
public interface AppComponent extends AndroidInjector<NewsApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<NewsApplication> {}
}
