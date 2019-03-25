package client.com.module_3.ui;

import android.support.design.widget.AppBarLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import client.com.baselibs.base.BaseActivity;
import client.com.baselibs.routeconstants.ArouteConstants;
import client.com.baselibs.utils.systembar.StatusBarUtil;
import client.com.module_3.R;

@Route(path = ArouteConstants.MODULE3_MEIZI_DETAIL_ACTIVITY_PATH)
public class MeiZiDetailActivity extends BaseActivity {
   private AppBarLayout appbarlayout;
   private PhotoView ivMeiziDetail;

    @Override
    public void initViews() {
        StatusBarUtil.setStatusBarColor(this, getResources().getColor(R.color.colorPrimary));
        appbarlayout=findViewById(R.id.appbarlayout);
        ivMeiziDetail=findViewById(R.id.iv_meizi_detail);
        initToolBar("图片详情", false);
        initData();
    }

    private void initData() {
        String picurl = getIntent().getStringExtra("picurl");
        Glide.with(this).load(picurl).into(ivMeiziDetail);
    }

    @Override
    public int getLayoutId() {
        return R.layout.module3_activity_mei_zi_detail;
    }



}
