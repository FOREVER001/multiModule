package client.com.baselibs.provider;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.template.IProvider;
/**
 * module_1暴露的服务
 * */
public interface HomeService extends IProvider{
    Fragment getHomeFragment();
}
