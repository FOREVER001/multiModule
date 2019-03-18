package client.com.module_1.ui.app;

import android.app.Application;

import client.com.baselibs.ServiceFactory;
import client.com.baselibs.app.BaseApp;
import client.com.module_1.ui.service.AccountService;

/**
 * HomeApp
 * @author zxh17
 * @version 1.0
 * */
public class HomeApp extends BaseApp{
    @Override
    public void onCreate() {
        super.onCreate();
        initModuleApp(this);
        initModuleData(this);
    }

    @Override
    public void initModuleApp(Application application) {
        ServiceFactory.getInstance().setAccountService(new AccountService());
    }

    @Override
    public void initModuleData(Application application) {

    }
}
