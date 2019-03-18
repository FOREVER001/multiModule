package client.com.module_1.ui.provider;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import client.com.baselibs.provider.HomeService;
import client.com.baselibs.routeconstants.ArouteConstants;
import client.com.module_1.ui.ui.HomeFragment;
@Route(path = ArouteConstants.MODULE1_HOME_FRAGMENT_PATH,name = "home模块暴露的服务")
public class HomeServiceImpl implements HomeService{
    @Override
    public Fragment getHomeFragment() {
        return new HomeFragment();
    }

    @Override
    public void init(Context context) {

    }
}
