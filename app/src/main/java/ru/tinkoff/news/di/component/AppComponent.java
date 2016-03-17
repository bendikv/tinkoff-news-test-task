package ru.tinkoff.news.di.component;

import android.content.Context;

import com.path.android.jobqueue.JobManager;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Component;
import ru.tinkoff.news.api.service.NewsService;
import ru.tinkoff.news.data.models.NewsModel;
import ru.tinkoff.news.di.module.ApiModule;
import ru.tinkoff.news.di.module.AppModule;
import ru.tinkoff.news.di.module.DataModule;
import ru.tinkoff.news.jobqueue.news.BaseNewsJob;

/**
 * Created by bendik on 17.03.16.
 */
@Singleton
@Component(modules = {AppModule.class, DataModule.class, ApiModule.class})
public interface AppComponent {
    JobManager jobManager();
    Bus eventBus();
    Context appContext();

    OkHttpClient okHttpClient();

    NewsService newsService();
    NewsModel newsModel();

    void inject(BaseNewsJob baseNewsJob);
}
