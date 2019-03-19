package client.com.baselibs.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import client.com.baselibs.R;

public abstract class BaseFragment extends Fragment {
    private final String TAG = "BaseFragment";
    protected Context mContext;
    protected BaseActivity mActivity;
    private boolean isFragmentVisible;
    private boolean isReuseView;
    private boolean isFirstVisible;
    protected View rootView;
    Unbinder unbinder;



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        mActivity = (BaseActivity) context;

    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        initVariable();


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        rootView = view;

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = view;
        }
        if (getUserVisibleHint()) {
            if (isFirstVisible) {
                onFragmentFirstVisible();
                isFirstVisible = false;
            }
        }
        super.onViewCreated(isReuseView ? rootView : view, savedInstanceState);
        initViews(isReuseView ? rootView : view);

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onDestroyView() {
        initVariable();
        unbinder.unbind();
        super.onDestroyView();
    }

    //获取布局layouid
    public abstract int getLayoutId();
    public abstract void initViews(View view);
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (rootView == null) {
            return;
        }
        if (isFirstVisible && isVisibleToUser) {
            onFragmentFirstVisible();
            isFirstVisible = false;
            return;
        }
    }

    private void initVariable() {
        isFirstVisible = true;
        isFragmentVisible = false;
        isReuseView = true;
    }

    protected abstract void onFragmentFirstVisible();

    protected boolean isFragmentVisible() {
        return isFragmentVisible;
    }

    protected BaseActivity getBaseActivity(){
        return mActivity;
    }


    /**
     * 封装findViewById
     *
     * @param id          控件的id
     * @param contentView 布局view
     * @return T 返回相应的控件类型
     */
    protected static <T extends View> T getViewById(int id, View contentView) {
        return (T) contentView.findViewById(id);
    }
}
