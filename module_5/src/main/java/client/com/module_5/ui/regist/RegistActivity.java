package client.com.module_5.ui.regist;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import client.com.baselibs.base.BaseActivity;
import client.com.baselibs.routeconstants.ArouteConstants;
import client.com.baselibs.utils.ToastUtils;
import client.com.baselibs.utils.systembar.StatusBarUtil;
import client.com.module_5.R;
import client.com.module_5.R2;

/**
 * 注册页面
 *
 * @author zxh17
 * @version 1.0
 */
@Route(path = ArouteConstants.MODULE5_REGIST_ACTIVITY_PATH)
public class RegistActivity extends BaseActivity implements RegistContract.View{

    @BindView(R2.id.toolbar)
    Toolbar toolbar;
    @BindView(R2.id.appbarlayout)
    AppBarLayout appbarlayout;
    @BindView(R2.id.et_phone)
    EditText etPhone;
    @BindView(R2.id.til_phone)
    TextInputLayout tilPhone;
    @BindView(R2.id.et_password)
    EditText etPassword;
    @BindView(R2.id.til_password)
    TextInputLayout tilPassword;
    @BindView(R2.id.et_phoneagain)
    EditText etPhoneagain;
    @BindView(R2.id.til_passwordagain)
    TextInputLayout tilPasswordagain;
    @BindView(R2.id.tv_register)
    TextView tvRegister;
    private RegistContract.Preseter presenter;

    @Override
    public void initViews() {
        StatusBarUtil.setStatusBarColor(this, getResources().getColor(R.color.colorPrimary));
        initToolBar("注册", false);
        new RegistPreseter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.module5_activity_regist;
    }

    @OnClick(R2.id.tv_register)
    public void onViewClicked() {
        String phone = etPhone.getText().toString().trim();
        String pwd = etPassword.getText().toString().trim();
        String againPwd = etPhoneagain.getText().toString().trim();
        presenter.regist(phone,pwd,againPwd);
    }



    @Override
    public void showIndicator(String msg) {
        ToastUtils.showToast(msg);
    }

    @Override
    public void setPresenter(RegistContract.Preseter presenter) {
        this.presenter=presenter;
    }
}
