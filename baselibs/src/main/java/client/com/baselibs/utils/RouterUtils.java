package client.com.baselibs.utils;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;

public class RouterUtils {
    /**
     * 通过url,bundle跳转页面
     *
     * @param url
     * @param bundle
     */
    public static void goToActivity(String url, Bundle bundle) {
        ARouter.getInstance().build(url).with(bundle).navigation();
    }
}
