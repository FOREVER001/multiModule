package client.com.componentbasedproject;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import client.com.baselibs.base.BaseActivity;
import client.com.baselibs.provider.ChapterService;
import client.com.baselibs.provider.HomeService;
import client.com.baselibs.provider.MeiziService;
import client.com.baselibs.provider.ProjectService;
import client.com.baselibs.routeconstants.ArouteConstants;
import client.com.baselibs.utils.LogUtils;

@Route(path = ArouteConstants.APP_MAIN_ACTIVITY_PATH)
public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.bottomnavigation)
    BottomNavigationView bottomnavigation;
    private MainPageAdapter mMainPageAdapter;
    @Autowired(name = ArouteConstants.MODULE1_HOME_FRAGMENT_PATH)
     HomeService mHomeService;
    @Autowired(name = ArouteConstants.MODULE2_PUBLICE_FRAGMENT_PATH)
    ChapterService mChapterService;
    @Autowired(name = ArouteConstants.MODULE3_MEIZI_FRAGMENT_PATH)
    MeiziService mMeiziService;
    @Autowired(name = ArouteConstants.MODULE4_PROJECT_FRAGMENT_PATH)
    ProjectService mProjectService;

    @Override
    public void initViews() {
        initData();
        initEvent();

    }

    private void initEvent() {
        bottomnavigation.setOnNavigationItemSelectedListener(this);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changePage(position);
                supportInvalidateOptionsMenu();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void initData() {
        mMainPageAdapter = new MainPageAdapter(getSupportFragmentManager(), initFragment());
        viewPager.setAdapter(mMainPageAdapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.app_activity_main;
    }
    private List<Fragment> initFragment() {
        List<Fragment> mFragments = new ArrayList<>();
        mFragments.add( mHomeService.getHomeFragment());
        mFragments.add(mChapterService.getPublicArticleFragment());
        mFragments.add(mMeiziService.getMeiziFragment());
        mFragments.add(mProjectService.getProjectFragment());
        return mFragments;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.tab_one:
                clickTab(0);
                //返回true,否则tab按钮不变色,未被选中
                return true;
            case R.id.tab_two:
                clickTab(1);
                return true;
            case R.id.tab_three:
                clickTab(2);
                return true;
            case R.id.tab_four:
                clickTab(3);
                return true;
            default:
                break;
        }
        return false;
    }
    private void clickTab(int item) {
        //为防止隔页切换时,滑过中间页面的问题,去除页面切换缓慢滑动的动画效果
        viewPager.setCurrentItem(item, false);
        supportInvalidateOptionsMenu();
    }
    private void changePage(int position) {
        switch (position) {
            case 0:
                bottomnavigation.setSelectedItemId(R.id.tab_one);
                break;
            case 1:
                bottomnavigation.setSelectedItemId(R.id.tab_two);
                break;
            case 2:
                bottomnavigation.setSelectedItemId(R.id.tab_three);
                break;
            case 3:
                bottomnavigation.setSelectedItemId(R.id.tab_four);
                break;
            default:
                break;
        }
    }
}
