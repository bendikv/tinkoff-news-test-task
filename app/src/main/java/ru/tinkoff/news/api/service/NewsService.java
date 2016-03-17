package ru.tinkoff.news.api.service;

import retrofit.http.GET;
import retrofit.http.Query;
import ru.tinkoff.news.data.vo.PayloadContent;
import ru.tinkoff.news.data.vo.PayloadNewsList;

/**
 * Created by bendik on 17.03.16.
 */
public interface NewsService {
    @GET("/news")
    PayloadNewsList getNews();
    @GET("/news_content")
    PayloadContent getNewsContent(@Query("id") long id);
}
