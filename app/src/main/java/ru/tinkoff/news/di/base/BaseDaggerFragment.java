package ru.tinkoff.news.di.base;

import android.content.Context;
import android.support.v4.app.Fragment;

import ru.tinkoff.news.App;
import ru.tinkoff.news.di.component.DaggerFragmentComponent;
import ru.tinkoff.news.di.component.FragmentComponent;

/**
 * Created by bendik on 17.03.16.
 */
public abstract class BaseDaggerFragment extends Fragment {
    private FragmentComponent mComponent;

    @Override
    public void onAttach(Context context) {
        buildComponent();
        onInject();
        super.onAttach(context);
    }

    private void buildComponent() {
        mComponent = DaggerFragmentComponent.builder()
                .appComponent(getApp().getAppComponent()).build();
    }

    protected App getApp() {
        return (App) ((BaseDaggerActivity) getActivity()).getApplicationContext();
    }


    protected abstract void onInject();

    public FragmentComponent getFragmentComponent() {
        return mComponent;
    }
}
