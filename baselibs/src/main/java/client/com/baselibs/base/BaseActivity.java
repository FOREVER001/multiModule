package client.com.baselibs.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.alibaba.android.arouter.launcher.ARouter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import client.com.baselibs.R;
import client.com.baselibs.event.NetworkChangeEvent;
import client.com.baselibs.utils.ActivityManage;
import client.com.baselibs.utils.NetUtils;
import client.com.baselibs.utils.systembar.StatusBarUtil;

/**
 * baseActivity
 * @author zxh
 * @version 1.0
 * **/
public abstract class BaseActivity extends AppCompatActivity {
    protected boolean mCheckNetWork = true; //默认检查网络状态
    View mTipView;
    WindowManager mWindowManager;
    WindowManager.LayoutParams mLayoutParams;
    public void setCheckNetWork(boolean checkNetWork) {
        mCheckNetWork = checkNetWork;
    }

    public boolean isCheckNetWork() {
        return mCheckNetWork;
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ARouter.getInstance().inject(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initSystemBar();
        ButterKnife.bind(this);
        ActivityManage.addActivity(this);
        initViews();
        initTipView();//初始化提示View
        EventBus.getDefault().register(this);
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
        //在无网络情况下打开APP时，系统不会发送网络状况变更的Intent，需要自己手动检查
        hasNetWork(NetUtils.isConnected(this));
    }
    private void hasNetWork(boolean has) {
        if (isCheckNetWork()) {
            if (has) {
                if (mTipView != null && mTipView.getParent() != null) {
                    mWindowManager.removeView(mTipView);
                }
            } else {
                if (mTipView.getParent() == null) {
                    mWindowManager.addView(mTipView, mLayoutParams);
                }
            }
        }
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
        EventBus.getDefault().unregister(this);
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

    /**
     * 统一初始化titlebar
     */
    protected Toolbar initToolBar(String title, boolean rightImgIsShow) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(Html.fromHtml(title));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });
        return toolbar;
    }
    protected void back() {
        finish();
    }

    private void initTipView() {
        LayoutInflater inflater = getLayoutInflater();
        mTipView = inflater.inflate(R.layout.layout_network_tip, null); //提示View布局
        mWindowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        mLayoutParams = new WindowManager.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                PixelFormat.TRANSLUCENT);
        //使用非CENTER时，可以通过设置XY的值来改变View的位置
        mLayoutParams.gravity = Gravity.TOP;
        mLayoutParams.x = 0;
        mLayoutParams.y = 0;
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNetworkChangeEvent(NetworkChangeEvent event) {
        hasNetWork(event.isConnected);
    }

    @Override
    public void finish() {
        super.finish();
        //当提示View被动态添加后直接关闭页面会导致该View内存溢出，所以需要在finish时移除
        if (mTipView != null && mTipView.getParent() != null) {
            mWindowManager.removeView(mTipView);
        }


    }
}
