package ru.tinkoff.news.jobqueue.news;

import com.path.android.jobqueue.Params;

import javax.inject.Inject;

import ru.tinkoff.news.api.service.NewsService;
import ru.tinkoff.news.data.models.NewsModel;
import ru.tinkoff.news.di.component.AppComponent;
import ru.tinkoff.news.jobqueue.BaseJob;
import ru.tinkoff.news.jobqueue.Groups;

/**
 * Created by bendik on 17.03.16.
 */
public abstract class BaseNewsJob extends BaseJob {
    @Inject protected transient NewsService mNewsService;
    @Inject protected transient NewsModel mNewsModel;
    public BaseNewsJob() {
        super(new Params(BACKGROUND).groupBy(Groups.MAIN_CONTENT));
    }

    @Override
    public void inject(AppComponent appComponent) {
        appComponent.inject(this);
    }
}
