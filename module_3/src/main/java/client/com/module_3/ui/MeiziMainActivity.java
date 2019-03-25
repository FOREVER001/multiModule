package client.com.module_3.ui;



import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;

import client.com.baselibs.base.BaseActivity;
import client.com.baselibs.routeconstants.ArouteConstants;
import client.com.baselibs.utils.RouterUtils;
import client.com.baselibs.utils.systembar.StatusBarUtil;
import client.com.module_3.R;

public class MeiziMainActivity extends BaseActivity {


    @Override
    public void initViews() {
        StatusBarUtil.setStatusBarColor(this, getResources().getColor(R.color.colorPrimary));
        Fragment fragment = RouterUtils.getFragment(ArouteConstants.MODULE3_MEIZI_PAGE_PATH);
        android.support.v4.app.FragmentManager supportFragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_content_girls, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public int getLayoutId() {
        return R.layout.module3_activity_meizi_main;
    }
}
