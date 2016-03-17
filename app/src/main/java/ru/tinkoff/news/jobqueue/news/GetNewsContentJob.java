package ru.tinkoff.news.jobqueue.news;

import ru.tinkoff.news.controllers.NewsController;
import ru.tinkoff.news.controllers.NewsEvents;
import ru.tinkoff.news.data.vo.News;
import ru.tinkoff.news.data.vo.PayloadContent;
import ru.tinkoff.news.data.vo.Response;

/**
 * Created by bendik on 17.03.16.
 */
public class GetNewsContentJob extends BaseNewsJob {
    private final transient NewsController mNewsController;
    private final long id;

    public GetNewsContentJob(NewsController mNewsController, long id) {
        this.mNewsController = mNewsController;
        this.id = id;
    }

    @Override
    public void onRun() throws Throwable {
        PayloadContent payload = mNewsService.getNewsContent(id);
        if (Response.RESULT.OK.equals(payload.getResultCode())) {
            String content = payload.getPayload().getContent();
            mNewsModel.updateContent(id, content);
            News news = mNewsModel.load(id);
            mNewsController.handleNewsContent(news);
        } else {
            mNewsController.handleNetworkException(new NewsEvents.NewsListFetchFailed(payload));
        }
    }

    @Override
    protected void onCancel() {
        super.onCancel();
        mNewsController.handleNetworkException(new NewsEvents.NetworkExceptionEvent(getNetworkException()));
    }
}
