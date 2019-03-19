package client.com.module_3.ui.meizilist;

import java.util.List;

import client.com.baselibs.http.model.module3.MeiziModel;
import client.com.baselibs.mvp.BasePresenter;
import client.com.baselibs.mvp.BaseView;
/**
 * 福利列表contract
 * @author zxh17
 * @version 1.0
 * */
public interface MeiziListContract {
    interface View extends BaseView<Preseter>{
        void showIndicator(String msg);
        void showMeiZiSucess(List<MeiziModel.ResultsBean> results);
    }
    interface Preseter extends BasePresenter{
        void getGankData(int page);
    }
}
