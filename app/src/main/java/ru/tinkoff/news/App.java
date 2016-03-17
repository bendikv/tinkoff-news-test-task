package ru.tinkoff.news;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

import ru.tinkoff.news.di.component.AppComponent;
import ru.tinkoff.news.di.component.DaggerAppComponent;
import ru.tinkoff.news.di.module.AppModule;
import timber.log.Timber;
/**
 * Created by bendik on 17.03.16.
 */
public class App extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            // TODO Timber.plant(new CrashlyticsTree());
        }
        buildComponent();
    }

    private void buildComponent() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
