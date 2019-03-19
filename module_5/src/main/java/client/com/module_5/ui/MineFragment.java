package client.com.module_5.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import client.com.baselibs.base.BaseFragment;
import client.com.baselibs.widget.CircleImageView;
import client.com.module_5.R;
import client.com.module_5.R2;

/**
 * 个人中心
 *
 * @author zxh17
 * @version 1.0
 */
public class MineFragment extends BaseFragment {


    @BindView(R2.id.iv_avator)
    CircleImageView ivAvator;
    @BindView(R2.id.tv_nickname)
    TextView tvNickname;
    @BindView(R2.id.fl_favor)
    FrameLayout flFavor;
    @BindView(R2.id.fl_todo_tool)
    FrameLayout flTodoTool;
    @BindView(R2.id.fl_setting)
    FrameLayout flSetting;
    @BindView(R2.id.fl_about)
    FrameLayout flAbout;


    public MineFragment() {
    }


    @Override
    public int getLayoutId() {
        return R.layout.module5_fragment_mine;
    }

    @Override
    public void initViews(View view) {

    }

    @Override
    protected void onFragmentFirstVisible() {

    }



    @OnClick({R2.id.iv_avator, R2.id.fl_favor, R2.id.fl_todo_tool, R2.id.fl_setting, R2.id.fl_about})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.iv_avator) {

        } else if (i == R.id.fl_favor) {

        } else if (i == R.id.fl_todo_tool) {

        } else if (i == R.id.fl_setting) {

        } else if (i == R.id.fl_about) {
        }
    }
}
