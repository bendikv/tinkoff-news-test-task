package ru.tinkoff.news.di.component;

import dagger.Component;
import ru.tinkoff.news.di.scope.ActivityScope;
import ru.tinkoff.news.ui.main.MainActivity;
import ru.tinkoff.news.ui.main.news.DetailedNewsActivity;

@ActivityScope
@Component(dependencies = AppComponent.class)
public interface ActivityComponent extends AppComponent {
    void inject(MainActivity activity);
    void inject(DetailedNewsActivity activity);
}
