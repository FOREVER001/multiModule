package client.com.module_2.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

import client.com.baselibs.routeconstants.ArouteConstants;
import client.com.module_2.R;
@Route(path = ArouteConstants.MODULE2_MAIN_ACTIVITY_PATH)
public class Module2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module2_activity_module2);
    }
}
