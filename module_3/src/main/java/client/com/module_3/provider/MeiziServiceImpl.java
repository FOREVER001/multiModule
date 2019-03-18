package client.com.module_3.provider;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;

import client.com.baselibs.provider.MeiziService;
import client.com.baselibs.routeconstants.ArouteConstants;
import client.com.module_3.ui.MeiZiFragment;
/**
 * 福利模块暴露服务的实现类
 * @author zxh17
 * @version 1.0
 * */
@Route(path = ArouteConstants.MODULE3_MEIZI_FRAGMENT_PATH,name = "获取福利模块实例")
public class MeiziServiceImpl implements MeiziService {
    @Override
    public Fragment getMeiziFragment() {
        return new MeiZiFragment();
    }

    @Override
    public void init(Context context) {

    }
}
