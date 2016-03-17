package ru.tinkoff.news.data.models;

import android.database.sqlite.SQLiteDatabase;

import ru.tinkoff.news.App;
import ru.tinkoff.news.di.component.AppComponent;

public class BaseModel {

    protected final SQLiteDatabase mSQLiteDatabase;
    protected final AppComponent mComponent;

    public BaseModel(App app, SQLiteDatabase database) {
        mComponent = app.getAppComponent();
        mSQLiteDatabase = database;
    }
}
