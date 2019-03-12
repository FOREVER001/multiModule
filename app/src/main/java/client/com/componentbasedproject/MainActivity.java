package client.com.componentbasedproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import client.com.baselibs.routeconstants.ArouteConstants;

@Route(path = ArouteConstants.APP_MAIN_ACTIVITY_PATH)
public class MainActivity extends AppCompatActivity  {
    @BindView(R.id.btn_module1)
    Button btnModule1;
    @BindView(R.id.btn_module2)
    Button btnModule2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_main);
        ButterKnife.bind(this);

    }



    @OnClick({R.id.btn_module1, R.id.btn_module2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_module1:
                ARouter.getInstance().build(ArouteConstants.MODULE1_MAIN_ACTIVITY_PATH).navigation();
                break;
            case R.id.btn_module2:
                ARouter.getInstance().build(ArouteConstants.MODULE2_MAIN_ACTIVITY_PATH).navigation();
                break;
        }
    }
}
