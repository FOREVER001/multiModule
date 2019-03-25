package client.com.module_1.ui.data;

import client.com.baselibs.http.Http;
import io.reactivex.Observable;

public class Module5HttpData {
    public Module5HttpData() {
    }
    /**
     * 轮播图
     *
     */
    public Observable getBanner() {
        Observable observable = Http.getDefault().getBanner();
        return observable;
    }
    /**
     * 轮播图
     *
     */
    public Observable getArticleList(int page) {
        Observable observable = Http.getDefault().getArticle(page);
        return observable;
    }
}
