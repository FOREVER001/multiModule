package client.com.baselibs.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;

import client.com.baselibs.constants.Constants;
import client.com.baselibs.interceptor.BaseLoginInterceptor;

public class RouterUtils {
    /**
     * 通过url跳转页面
     *
     * @param url
     */
    public static void goToActivity(String url) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(Constants.IS_LOGIN, SharePreferenceUtil.getBoolean(Constants.IS_LOGIN, false));
        ARouter.getInstance().build(url).with(bundle).setProvider(new BaseLoginInterceptor()).navigation();
    }
    /**
     * 通过url,bundle跳转页面
     *
     * @param url
     * @param bundle
     */
    public static void goToActivity(String url, Bundle bundle) {
        ARouter.getInstance().build(url).with(bundle).navigation();
    }
    /**
     * 获取Fragment
     *
     * @return
     */
    public static Fragment getFragment(String url) {
        return (Fragment) ARouter.getInstance().build(url).navigation();
    }


}
