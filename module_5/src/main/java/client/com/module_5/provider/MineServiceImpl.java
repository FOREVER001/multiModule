package client.com.module_5.provider;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;

import client.com.baselibs.provider.MineService;
import client.com.baselibs.routeconstants.ArouteConstants;
import client.com.module_5.ui.MineFragment;

@Route(path = ArouteConstants.MODULE5_MINE_FRAGMENT_PATH,name = "个人中心暴露服务")
public class MineServiceImpl implements MineService {
    @Override
    public Fragment getMineFragment() {
        return new MineFragment();
    }

    @Override
    public void init(Context context) {

    }
}
