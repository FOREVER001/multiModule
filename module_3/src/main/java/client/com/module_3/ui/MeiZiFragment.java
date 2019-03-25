package client.com.module_3.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

import butterknife.BindView;
import client.com.baselibs.base.BaseFragment;
import client.com.baselibs.base.BaseLazyFragment;
import client.com.baselibs.http.model.module3.MeiziModel;
import client.com.baselibs.routeconstants.ArouteConstants;
import client.com.baselibs.utils.LogUtils;
import client.com.baselibs.utils.RouterUtils;
import client.com.baselibs.utils.ToastUtils;
import client.com.module_3.BuildConfig;
import client.com.module_3.R;
import client.com.module_3.R;
import client.com.module_3.adapter.MeiziAdapter;
import client.com.module_3.ui.meizilist.MeiziListContract;
import client.com.module_3.ui.meizilist.MeiziListPreseter;

/**
 * 福利fragment
 *
 * @author zxh17
 * @version 1.0
 */
@Route(path = ArouteConstants.MODULE3_MEIZI_PAGE_PATH)
public class MeiZiFragment extends BaseFragment implements MeiziListContract.View{


    private RecyclerView recyclerview;
    private SmartRefreshLayout smartRefresh;
    private MeiziListContract.Preseter presenter;
    private int pageIndex=0;
    private List<MeiziModel.ResultsBean> results;
    private MeiziAdapter mMeiziAdapter;

    public MeiZiFragment() {
    }

    @Override
    public int getLayoutId() {
        if(BuildConfig.isneedmodule3){
            return R.layout.module3_fragment_mei_zi;
        }else {
            return R.layout.module3_fragment_mei_zi1;
        }

    }

    @Override
    public void initViews(View view) {
         findViews(view);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(staggeredGridLayoutManager);
        mMeiziAdapter = new MeiziAdapter(results);
        recyclerview.setAdapter(mMeiziAdapter);
        initEvent();
    }

    private void findViews(View view) {
        recyclerview=view.findViewById(R.id.recyclerview);
        smartRefresh=view.findViewById(R.id.smart_refresh);
    }

    private void initEvent() {
        smartRefresh.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                pageIndex++;
                presenter.getGankData(pageIndex);
                refreshLayout.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                pageIndex=0;
               presenter.getGankData(pageIndex);
                refreshLayout.finishRefresh();
            }
        });

//        recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                if(newState==RecyclerView.SCROLL_STATE_IDLE){
//                    Glide.with(mContext).resumeRequests();
//                }else {
//                    Glide.with(mContext).pauseRequests();
//                }
//            }
//        });

        mMeiziAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MeiziModel.ResultsBean resultsBean= (MeiziModel.ResultsBean) adapter.getData().get(position);
                String url = resultsBean.getUrl();
                Bundle bundle = new Bundle();
                bundle.putString("picurl", url);
                RouterUtils.goToActivity(ArouteConstants.MODULE3_MEIZI_DETAIL_ACTIVITY_PATH,bundle);
            }
        });
    }

    @Override
    protected void onFragmentFirstVisible() {
        intData();

    }



    private void intData() {
        new MeiziListPreseter(this,getBaseActivity());
        presenter.getGankData(pageIndex);
    }


    @Override
    public void showIndicator(String msg) {
        ToastUtils.showToast(msg);
    }

    @Override
    public void showMeiZiSucess(List<MeiziModel.ResultsBean> results) {
        mMeiziAdapter.addData(results);
    }

    @Override
    public void setPresenter(MeiziListContract.Preseter presenter) {
        this.presenter=presenter;
    }
}
