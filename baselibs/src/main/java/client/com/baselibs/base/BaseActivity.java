package client.com.baselibs.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import client.com.baselibs.utils.ActivityManage;
import client.com.baselibs.utils.systembar.StatusBarUtil;

/**
 * baseActivity
 * @author zxh
 * @version 1.0
 * **/
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initSystemBar();
        ButterKnife.bind(this);
        ActivityManage.addActivity(this);
        initViews();
    }

    protected  void initSystemBar(){
        //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的 padding
        StatusBarUtil.setRootViewFitsSystemWindows(this,true);
        //设置状态栏透明
        StatusBarUtil.setTranslucentStatus(this);
        //一般的手机的状态栏文字和图标都是白色的, 可如果你的应用也是纯白色的, 或导致状态栏文字看不清
        //所以如果你是这种情况,请使用以下代码, 设置状态使用深色文字图标风格, 否则你可以选择性注释掉这个if内容
        if (!StatusBarUtil.setStatusBarDarkTheme(this, true)) {
            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
            //这样半透明+白=灰, 状态栏的文字能看得清
            StatusBarUtil.setStatusBarColor(this,0x55000000);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {

        super.onPause();

    }

    @Override
    protected void onStop() {

        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManage.removeActivity(this);

    }

    /**
     * 初始化 view
     */
    public abstract void initViews();

    /**
     * 获取布局id给setContentView()
     *
     * @return 布局id
     */
    public abstract int getLayoutId();

    public BaseActivity getActivity() {
        return this;
    }
}
