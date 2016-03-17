package ru.tinkoff.news.di.component;

import dagger.Component;
import ru.tinkoff.news.di.scope.FragmentScope;
import ru.tinkoff.news.ui.main.news.NewsFragment;
import ru.tinkoff.news.ui.main.news.NewsListFragment;

@FragmentScope
@Component(dependencies = AppComponent.class)
public interface FragmentComponent extends AppComponent {
    void inject(NewsListFragment fragment);
    void inject(NewsFragment newsFragment);
}
