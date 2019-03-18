package client.com.componentbasedproject;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import client.com.baselibs.base.BaseActivity;
import client.com.baselibs.provider.HomeService;
import client.com.baselibs.routeconstants.ArouteConstants;
import client.com.baselibs.utils.LogUtils;

@Route(path = ArouteConstants.APP_MAIN_ACTIVITY_PATH)
public class MainActivity extends BaseActivity {


    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.bottomnavigation)
    BottomNavigationView bottomnavigation;
    private MainPageAdapter mMainPageAdapter;
    @Autowired(name = ArouteConstants.MODULE1_HOME_FRAGMENT_PATH)
     HomeService mHomeService;

    @Override
    public void initViews() {


        mMainPageAdapter = new MainPageAdapter(getSupportFragmentManager(), initFragment());
        viewPager.setAdapter(mMainPageAdapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.app_activity_main;
    }
    private List<Fragment> initFragment() {
        List<Fragment> mFragments = new ArrayList<>();
        Fragment homeFragment = mHomeService.getHomeFragment();
        LogUtils.e("=======homeFragment======"+homeFragment);
        mFragments.add(homeFragment);
        return mFragments;
    }
}
