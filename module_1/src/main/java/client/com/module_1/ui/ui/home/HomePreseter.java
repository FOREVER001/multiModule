package client.com.module_1.ui.ui.home;

import android.content.Context;

import java.util.List;

import client.com.baselibs.http.Transformer;
import client.com.baselibs.http.model.module1.ArticleListModel;
import client.com.baselibs.http.model.module1.BannerModel;
import client.com.baselibs.http.model.module1.HomeModel;
import client.com.baselibs.http.observer.CommonObserver;
import client.com.module_1.ui.data.Module5HttpData;
import io.reactivex.functions.BiFunction;

public class HomePreseter implements HomeContract.Preseter{
    private HomeContract.View view;
    private Module5HttpData httpData;
    private Context context;

    public HomePreseter(HomeContract.View view,Context context) {
        this.view = view;
        view.setPresenter(this);
        this.context = context;
        httpData = new Module5HttpData();
        start();
    }
    @Override
    public void getBanner() {

    }

    @Override
    public void getHomeData(int page) {
        httpData.getBanner().compose(Transformer.switchSchedulers())
                           .zipWith(httpData.getArticleList(page).compose(Transformer.switchSchedulers())
                                   , new BiFunction<BannerModel,ArticleListModel,HomeModel>() {
                                       @Override
                                       public HomeModel apply(BannerModel bannerModel, ArticleListModel articleListModel) throws Exception {
                                           return new HomeModel(bannerModel, articleListModel);
                                       }
                                   } )
                .subscribe(new CommonObserver<HomeModel>(context,true) {
                    @Override
                    protected void onError(String errorMsg) {
                        view.showIndicator(errorMsg);
                    }

                    @Override
                    protected void onSuccess(HomeModel homeModel) {
                        view.showHomeResult(homeModel);
                    }

                });

    }


    @Override
    public void start() {

    }
}
