package client.com.module_5.ui.regist;

import android.content.Context;

import client.com.baselibs.http.Transformer;
import client.com.baselibs.http.observer.CommonObserver;
import client.com.baselibs.utils.LogUtils;
import client.com.module_5.data.Module5HttpData;

public class RegistPreseter implements RegistContract.Preseter{
    private RegistContract.View view;
    private Module5HttpData httpData;
    private Context context;

    public RegistPreseter(RegistContract.View view) {
        this.view = view;
        view.setPresenter(this);
        context = (Context) view;
        httpData = new Module5HttpData();
        start();
    }
    /**
     * 注册页面
     * @param repassword
     * @param password
     * @param username
     * */
    @Override
    public void regist(String username, String password, String repassword) {
        httpData.regist(username,password,repassword)
                .compose(Transformer.switchSchedulers())
                .subscribe(new CommonObserver() {
                    @Override
                    protected void onError(String errorMsg) {
                        view.showIndicator(errorMsg);
                    }

                    @Override
                    protected void onSuccess(Object o) {
                        LogUtils.e("===========onSuccess======");
                    }
                });
    }

    @Override
    public void start() {

    }
}
