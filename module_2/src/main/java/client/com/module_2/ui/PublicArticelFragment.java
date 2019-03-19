package client.com.module_2.ui;

import android.view.View;

import client.com.baselibs.base.BaseFragment;
import client.com.baselibs.base.BaseLazyFragment;
import client.com.module_2.R;

/**
 * 公众号页面
 * @author zxh17
 * @version 1.0
 */
public class PublicArticelFragment extends BaseLazyFragment{
    public PublicArticelFragment() {
    }


    @Override
    public int getLayoutId() {
        return R.layout.module2_fragment_public_articel;
    }

    @Override
    protected void onLazyLoad() {

    }



}
