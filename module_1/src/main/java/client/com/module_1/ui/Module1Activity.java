package client.com.module_1.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

import butterknife.BindView;
import butterknife.OnClick;
import client.com.baselibs.base.BaseActivity;
import client.com.baselibs.routeconstants.ArouteConstants;
import client.com.module_1.R;
import client.com.module_1.R2;

@Route(path = ArouteConstants.MODULE1_MAIN_ACTIVITY_PATH)
public class Module1Activity extends BaseActivity {

    @BindView(R2.id.tv_module1)
    TextView tvModule1;
    @BindView(R2.id.tv_test)
    Button tvTest;


    @Override
    public void initViews() {
        tvModule1.setText("按钮");
        tvTest.setText("hahahh");

    }

    @Override
    public int getLayoutId() {
        return R.layout.module1_activity_module1;
    }

    @OnClick({R2.id.tv_module1, R2.id.tv_test})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.tv_module1) {
            Toast.makeText(this, "123", Toast.LENGTH_SHORT).show();
        } else if (i == R.id.tv_test) {
            Toast.makeText(this, "456", Toast.LENGTH_SHORT).show();
        }
    }


}
