package client.com.componentbasedproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;
/**
 * MainPreseter
 * @author zxh17
 * @version 1.0
 * */
public class MainPageAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments;

    public MainPageAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
