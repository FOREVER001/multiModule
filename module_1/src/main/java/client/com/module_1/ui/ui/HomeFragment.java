package client.com.module_1.ui.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import client.com.baselibs.base.BaseFragment;
import client.com.baselibs.base.BaseLazyFragment;
import client.com.module_1.R;

/**
 * 首页
 * @author zxh17
 * @version 1.0
 */
public class HomeFragment extends BaseLazyFragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayoutId() {
        return R.layout.module1_fragment_home;
    }

    @Override
    protected void onLazyLoad() {

    }




}
