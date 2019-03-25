package client.com.module_5.ui.login;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;

import org.greenrobot.eventbus.EventBus;

import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;
import client.com.baselibs.base.BaseActivity;
import client.com.baselibs.routeconstants.ArouteConstants;
import client.com.baselibs.utils.CommentUtil;
import client.com.baselibs.utils.RouterUtils;
import client.com.baselibs.utils.ToastUtils;
import client.com.baselibs.utils.systembar.StatusBarUtil;
import client.com.module_5.R;
import client.com.module_5.R2;
import client.com.module_5.data.UpdateInfoEvent;

/**
 * 登录页面
 *
 * @author zxh17
 * @version 1.0
 */
@Route(path = ArouteConstants.MODULE5_LOGIN_ACTIVITY_PATH)
public class LoginActivity extends BaseActivity implements LoginContract.View{

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
    @BindView(R2.id.login_btn)
    TextView loginBtn;
    @BindView(R2.id.login_change_password)
    TextView loginChangePassword;
    @BindView(R2.id.login_register)
    TextView loginRegister;
    private LoginContract.Preseter presenter;

    @Override
    public void initViews() {
        StatusBarUtil.setStatusBarColor(this, getResources().getColor(R.color.colorPrimary));
        initToolBar("登录", false);
        etPhone.setText("15225962303");
        etPassword.setText("123456");
        new LoginPreseter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.module5_activity_login;
    }



    @OnClick({R2.id.login_btn, R2.id.login_register})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.login_btn) {
            login();
        } else if (i == R.id.login_register) {
            RouterUtils.goToActivity(ArouteConstants.MODULE5_REGIST_ACTIVITY_PATH);
        }
    }

    private void login() {
        String account = Objects.requireNonNull(tilPhone.getEditText()).getText().toString();
        String password = Objects.requireNonNull(tilPassword.getEditText()).getText().toString();
        tilPhone.setErrorEnabled(false);
        tilPassword.setErrorEnabled(false);
        if (validateAccount(account) && validatePassword(password)) {
            presenter.login(account,password);
        }

    }

    /**
     * 验证用户名
     *
     * @param account
     * @return
     */
    private boolean validateAccount(String account) {
        if (TextUtils.isEmpty(account)) {
            showError(tilPhone, "手机号不能为空");
            return false;
        }
        if (CommentUtil.isMobilePhone(account)) {
            showError(tilPhone, "手机号格式不正确");
            return false;
        }
        return true;

    }
    /**
     * 验证密码
     *
     * @param password
     * @return
     */
    private boolean validatePassword(String password) {
        if (TextUtils.isEmpty(password)) {
            showError(tilPassword, "密码不能为空");
            return false;
        }

        //<6  >18
        if (password.length() < 6 || password.length() > 18) {
            showError(tilPassword, "密码长度为6-18位");
            return false;
        }

        return true;
    }
    /**
     * 显示错误提示，并获取焦点
     *
     * @param textInputLayout
     * @param error
     */
    private void showError(TextInputLayout textInputLayout, String error) {
        textInputLayout.setError(error);
        Objects.requireNonNull(textInputLayout.getEditText()).setFocusable(true);
        textInputLayout.getEditText().setFocusableInTouchMode(true);
        textInputLayout.getEditText().requestFocus();
    }

    @Override
    public void showIndicator(String msg) {
        ToastUtils.showToast(msg);
    }

    /**
     * 登录成功
     * */
    @Override
    public void loginSucess(String mobile) {
        EventBus.getDefault().post(new UpdateInfoEvent(mobile));
        finish();
    }

    @Override
    public void setPresenter(LoginContract.Preseter presenter) {
        this.presenter=presenter;
    }
}
