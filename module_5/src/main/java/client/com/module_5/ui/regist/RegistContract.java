package client.com.module_5.ui.regist;

import client.com.baselibs.mvp.BasePresenter;
import client.com.baselibs.mvp.BaseView;

public interface RegistContract {
    interface View extends BaseView<Preseter> {
        void showIndicator(String msg);
    }
    interface Preseter extends BasePresenter{
        void regist(String username,String password,String repassword);
    }
}
