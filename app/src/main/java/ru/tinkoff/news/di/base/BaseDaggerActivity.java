package ru.tinkoff.news.di.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.squareup.otto.Bus;

import javax.inject.Inject;

import ru.tinkoff.news.App;
import ru.tinkoff.news.di.component.ActivityComponent;
import ru.tinkoff.news.di.component.DaggerActivityComponent;

/**
 * Created by bendik on 17.03.16.
 */
public abstract class BaseDaggerActivity extends AppCompatActivity {
    @Inject protected Bus eventBus;

    private Object parentEventListener;
    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buildComponent();
        onInject();
        parentEventListener = new Object() {
            // Events
        };
    }

    private void buildComponent() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent(getApp().getAppComponent()).build();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    protected App getApp() {
        return (App) getApplicationContext();
    }


    protected abstract void onInject();

    @Override
    protected void onResume() {
        super.onResume();
        eventBus.register(this);
        eventBus.register(parentEventListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        eventBus.unregister(this);
        eventBus.unregister(parentEventListener);
    }
}
