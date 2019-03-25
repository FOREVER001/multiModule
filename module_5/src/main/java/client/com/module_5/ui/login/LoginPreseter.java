package client.com.module_5.ui.login;

import android.content.Context;

import client.com.baselibs.constants.Constants;
import client.com.baselibs.http.Transformer;
import client.com.baselibs.http.model.module5.LoginModel;
import client.com.baselibs.http.observer.CommonObserver;
import client.com.baselibs.utils.LogUtils;
import client.com.baselibs.utils.SharePreferenceUtil;
import client.com.module_5.data.Module5HttpData;

public class LoginPreseter implements LoginContract.Preseter{
    private LoginContract.View view;
    private Module5HttpData httpData;
    private Context context;

    public LoginPreseter(LoginContract.View view) {
        this.view = view;
        view.setPresenter(this);
        context = (Context) view;
        httpData = new Module5HttpData();
        start();
    }
    @Override
    public void login(String username, String password) {
        httpData.login(username,password)
                .compose(Transformer.switchSchedulers())
                .subscribe(new CommonObserver<LoginModel>(context,true) {
                    @Override
                    protected void onError(String errorMsg) {
                        view.showIndicator(errorMsg);
                    }

                    @Override
                    protected void onSuccess(LoginModel loginModel) {
                        LogUtils.e("===========onSuccess=sss=====");
                        int errorCode = loginModel.getErrorCode();
                        if(errorCode==0){
                                saveData(loginModel);
                                view.loginSucess(loginModel.getData().getUsername());
                        }else {
                            view.showIndicator(loginModel.getErrorMsg());
                        }
                    }

                });
    }

    private void saveData(LoginModel loginModel) {
        if(loginModel!=null){
            SharePreferenceUtil.setBoolean(Constants.IS_LOGIN,true);
            SharePreferenceUtil.setString(Constants.USER_NAME,loginModel.getData().getUsername());
            SharePreferenceUtil.setString(Constants.PWD,loginModel.getData().getPassword());
        }
    }

    @Override
    public void start() {

    }
}
