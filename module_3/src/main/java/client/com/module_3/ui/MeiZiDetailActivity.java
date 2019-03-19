package client.com.module_3.ui;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import client.com.baselibs.base.BaseActivity;
import client.com.baselibs.routeconstants.ArouteConstants;
import client.com.baselibs.utils.systembar.StatusBarUtil;
import client.com.module_3.R;
import client.com.module_3.R2;

@Route(path = ArouteConstants.MODULE3_MEIZI_DETAIL_ACTIVITY_PATH)
public class MeiZiDetailActivity extends BaseActivity {


    @BindView(R2.id.toolbar)
    Toolbar toolbar;
    @BindView(R2.id.appbarlayout)
    AppBarLayout appbarlayout;
    @BindView(R2.id.iv_meizi_detail)
    PhotoView ivMeiziDetail;

    @Override
    public void initViews() {
        StatusBarUtil.setStatusBarColor(this,getResources().getColor(R.color.colorPrimary));
        initToolBar("图片详情", false);
        initData();
    }

    private void initData() {
        String picurl = getIntent().getStringExtra("picurl");
        Glide.with(this).load(picurl).into(ivMeiziDetail);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_mei_zi_detail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
