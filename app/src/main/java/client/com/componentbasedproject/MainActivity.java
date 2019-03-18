package client.com.componentbasedproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import client.com.baselibs.ServiceFactory;
import client.com.baselibs.base.BaseActivity;
import client.com.baselibs.routeconstants.ArouteConstants;
import client.com.baselibs.utils.LogUtils;
import client.com.module_1.R2;

@Route(path = ArouteConstants.APP_MAIN_ACTIVITY_PATH)
public class MainActivity extends BaseActivity {
    @BindView(R.id.btn_module1)
    Button btnModule1;
    @BindView(R.id.btn_module2)
    Button btnModule2;



    @Override
    public void initViews() {

       Fragment fragment= ServiceFactory.getInstance().getAccountService().newUserFragment(this, R.id.fl_content, getSupportFragmentManager(), null, "");
        LogUtils.e("=========fragment======"+fragment);
    }

    @Override
    public int getLayoutId() {
        return R.layout.app_activity_main;
    }


    @OnClick({R.id.btn_module1, R.id.btn_module2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_module1:
                ARouter.getInstance().build(ArouteConstants.MODULE1_MAIN_ACTIVITY_PATH).navigation();
                break;
            case R.id.btn_module2:
//                ARouter.getInstance().build(ArouteConstants.MODULE2_MAIN_ACTIVITY_PATH).navigation();
                startActivity(new Intent(this,FragmentActivity.class));
                break;
        }
    }
}
