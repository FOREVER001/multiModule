package client.com.module_2.ui;

import com.alibaba.android.arouter.facade.annotation.Route;

import client.com.baselibs.base.BaseActivity;
import client.com.baselibs.routeconstants.ArouteConstants;
import client.com.baselibs.utils.systembar.StatusBarUtil;
import client.com.module_2.R;

/**
 * 该页面的图片沉浸式效果
 * */
@Route(path = ArouteConstants.MODULE2_MAIN_ACTIVITY_PATH)
public class Module2Activity extends BaseActivity {


    @Override
    public void initViews() {
     //不要忘记了, 在当前activity onCreate中设置 取消padding,  因为这个padding 我们用代码实现了,不需要系统帮我
        StatusBarUtil.setRootViewFitsSystemWindows(this,false);
//        StatusBarUtil.setStatusBarColor(this, Color.parseColor("#ffffff"));
        StatusBarUtil.setStatusBarDarkTheme(this,false);
    }

    @Override
    public int getLayoutId() {
        return R.layout.module2_activity_module2;
    }
}
