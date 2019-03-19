package client.com.baselibs.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseLazyFragment extends Fragment{
    //该页面 是否已经准备完毕（onCreateView方法已调用完毕）
    private boolean isPrepared;
    //该fragment，是否已经执行过懒加载
    private boolean isLazyLoaded;
    Unbinder unbinder;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isPrepared=true;
        lazyLoad();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    protected abstract int getLayoutId();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        lazyLoad();
    }

    /**
     * 页面可见
     *  页面加载完成
     *  没有懒加载过
     * */
    protected  void lazyLoad(){
        if(getUserVisibleHint() && isPrepared && isLazyLoaded){
            onLazyLoad();
            isLazyLoaded=true;
        }
    }

    /**
     * 数据懒加载
     * */
    protected abstract void onLazyLoad();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
