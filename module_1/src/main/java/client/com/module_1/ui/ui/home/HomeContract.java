package client.com.module_1.ui.ui.home;

import java.util.List;

import client.com.baselibs.http.model.module1.BannerModel;
import client.com.baselibs.http.model.module1.HomeModel;
import client.com.baselibs.mvp.BasePresenter;
import client.com.baselibs.mvp.BaseView;

public interface HomeContract {
    interface View extends BaseView<Preseter>{
        void showIndicator(String msg);
        void showHomeResult(HomeModel model);
    }
    interface Preseter extends BasePresenter{
        void getBanner();
        void getHomeData(int page);
    }
}
