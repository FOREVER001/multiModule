package client.com.module_1.ui.ui.detail;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.facade.annotation.Route;

import butterknife.BindView;
import butterknife.ButterKnife;
import client.com.baselibs.base.BaseActivity;
import client.com.baselibs.routeconstants.ArouteConstants;
import client.com.baselibs.utils.systembar.StatusBarUtil;
import client.com.baselibs.widget.MyX5WebView;
import client.com.module_1.R;
import client.com.module_1.R2;

/**
 * 详情页面h5
 *
 * @author zxh17
 * @version 1.0
 */
@Route(path = ArouteConstants.MODULE1_ARTICLE_DETAIL_ACTIVITY_PATH)
public class WebDetailActivity extends BaseActivity {


    @BindView(R2.id.appbarlayout)
    AppBarLayout appbarlayout;

    @BindView(R2.id.webview_detail)
    MyX5WebView webviewDetail;

    @BindView(R2.id.ll_content)
    LinearLayout llContent;
    private String mWeburl;
    private String mTitle;


    @Override
    public void initViews() {
        StatusBarUtil.setStatusBarColor(this, getResources().getColor(R.color.colorPrimary));
        mWeburl = getIntent().getStringExtra("weburl");
        mTitle = getIntent().getStringExtra("title");
        initToolBar(mTitle, false);
        webviewDetail.setShowProgress(true);
        webviewDetail.loadUrl(mWeburl);
    }

    @Override
    public int getLayoutId() {
        return R.layout.module1_activity_web_detail;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        if (webviewDetail != null) {
            llContent.removeView(webviewDetail);  //从布局中移除webView
            webviewDetail.stopLoading();
            webviewDetail.getSettings().setJavaScriptEnabled(false);
            webviewDetail.clearHistory();
            webviewDetail.removeAllViews();
            webviewDetail.destroy();

        }
    }


}
