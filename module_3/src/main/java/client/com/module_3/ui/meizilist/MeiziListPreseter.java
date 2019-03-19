package client.com.module_3.ui.meizilist;

import android.content.Context;

import java.util.List;

import client.com.baselibs.http.Transformer;
import client.com.baselibs.http.handlereult.HttpResult;
import client.com.baselibs.http.model.module3.MeiziModel;
import client.com.baselibs.http.observer.CommonObserver;
import client.com.baselibs.utils.LogUtils;
import client.com.module_3.data.Module3HttpData;

public class MeiziListPreseter implements MeiziListContract.Preseter{
    private MeiziListContract.View view;
    private Module3HttpData httpData;
    private Context context;

    public MeiziListPreseter(MeiziListContract.View view,Context mContext) {
        this.view = view;
        view.setPresenter(this);
        context = mContext;
        httpData = new Module3HttpData();
        start();
    }
    @Override
    public void getGankData(int page) {
        httpData.getGankData(page)
                .compose(Transformer.switchSchedulers())
                .subscribe(new CommonObserver<MeiziModel>(context,true) {
                    @Override
                    protected void onError(String errorMsg) {
                        LogUtils.e("=========errorMsg======");

                        view.showIndicator(errorMsg);
                    }

                    @Override
                    protected void onSuccess(MeiziModel meiziModel) {
                        LogUtils.e("=========httpResult======"+meiziModel.getCode());
                        List<MeiziModel.ResultsBean> results = meiziModel.getResults();
                        view.showMeiZiSucess(results);
                    }



                });
    }

    @Override
    public void start() {

    }
}
