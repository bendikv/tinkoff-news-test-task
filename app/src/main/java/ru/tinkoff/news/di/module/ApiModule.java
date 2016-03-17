package ru.tinkoff.news.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.RestAdapter;
import ru.tinkoff.news.api.ApiEndpoint;
import ru.tinkoff.news.api.service.NewsService;

/**
 * Created by bendik on 17.03.16.
 */
@Module(includes = NetworkModule.class)
public class ApiModule {

    @Provides @Singleton
    Endpoint provideEndpoint() {
        return new ApiEndpoint();
    }

    @Provides
    @Singleton
    NewsService provideContentService(RestAdapter restAdapter) {
        return restAdapter.create(NewsService.class);
    }

}
