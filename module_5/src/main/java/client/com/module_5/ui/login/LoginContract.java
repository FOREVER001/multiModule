package client.com.module_5.ui.login;

import client.com.baselibs.mvp.BasePresenter;
import client.com.baselibs.mvp.BaseView;
import client.com.module_5.ui.regist.RegistContract;

public class LoginContract {
    interface View extends BaseView<LoginContract.Preseter> {
        void showIndicator(String msg);
        void loginSucess(String mobile);
    }
    interface Preseter extends BasePresenter {
        void login(String username,String password);
    }
}
