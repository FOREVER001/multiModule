package client.com.baselibs.provider;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.template.IProvider;
/**
 * 个人中心暴露的service
 * @author zxh17
 * @version 1.0
 * */
public interface MineService extends IProvider{
    Fragment getMineFragment();
}
