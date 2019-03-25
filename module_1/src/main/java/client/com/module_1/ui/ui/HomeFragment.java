package client.com.module_1.ui.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import client.com.baselibs.base.BaseFragment;
import client.com.baselibs.http.model.module1.ArticleListModel;
import client.com.baselibs.http.model.module1.BannerModel;
import client.com.baselibs.http.model.module1.HomeModel;
import client.com.baselibs.routeconstants.ArouteConstants;
import client.com.baselibs.utils.LogUtils;
import client.com.baselibs.utils.RouterUtils;
import client.com.baselibs.utils.ToastUtils;
import client.com.baselibs.widget.GlideImageLoader;
import client.com.module_1.R;
import client.com.module_1.R2;
import client.com.module_1.ui.adapter.MainArticleAdapter;
import client.com.module_1.ui.ui.home.HomeContract;
import client.com.module_1.ui.ui.home.HomePreseter;

/**
 * 首页
 *
 * @author zxh17
 * @version 1.0
 */
public class HomeFragment extends BaseFragment implements HomeContract.View{


    @BindView(R2.id.rv_main)
    RecyclerView rvMain;
    @BindView(R2.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    private HomeContract.Preseter presenter;
    private Banner bannerMain;
    private int mPageCount;
    private MainArticleAdapter adapter;
    private List<ArticleListModel.DataBean.DatasBean> articleListModels=new ArrayList<>();
    private int pageIndex=0;
    public HomeFragment() {
    }


    @Override
    public int getLayoutId() {
        return R.layout.module1_fragment_home;
    }

    @Override
    public void initViews(View view) {
        rvMain.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MainArticleAdapter(articleListModels);
        rvMain.setAdapter(adapter);
        View inflate = View.inflate(getActivity(), R.layout.module1_item_main_banner, null);
        bannerMain = inflate.findViewById(R.id.banner_main);
        adapter.addHeaderView(inflate);
    }

    @Override
    protected void onFragmentFirstVisible() {
        new HomePreseter(this,getBaseActivity());
        presenter.getHomeData(pageIndex);
    }


    @Override
    public void showIndicator(String msg) {
        ToastUtils.showToast(msg);
    }

    @Override
    public void showHomeResult(HomeModel model) {
        if(model!=null){
            dealBanner(model.getBannerModel());
            dealArtlist(model.getArticleListModel());
        }
    }

    private void dealBanner(BannerModel bannerModel) {
        loadBanner(bannerModel);
    }

    private void dealArtlist(ArticleListModel articleListModel) {
        mPageCount = articleListModel.getData().getPageCount();
        List<ArticleListModel.DataBean.DatasBean> datas = articleListModel.getData().getDatas();
         if(pageIndex==0){
             articleListModels.clear();
         }
        articleListModels.addAll(datas);
         adapter.setNewData(articleListModels);

         initEvent();
    }

    private void initEvent() {
        smartRefresh.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if(pageIndex<mPageCount){
                    pageIndex++;
                    presenter.getHomeData(pageIndex);
                }


                refreshLayout.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                pageIndex=0;
                presenter.getHomeData(pageIndex);
                refreshLayout.finishRefresh();
            }
        });

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("weburl", articleListModels.get(position).getLink());
                bundle.putString("title", articleListModels.get(position).getTitle());
                RouterUtils.goToActivity(ArouteConstants.MODULE1_ARTICLE_DETAIL_ACTIVITY_PATH, bundle);
            }
        });

    }


    @Override
    public void setPresenter(HomeContract.Preseter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void onStart() {
        super.onStart();
        bannerMain.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        bannerMain.stopAutoPlay();
    }
    public void loadBanner(BannerModel bannerModel){
        //设置图片集合
        List<String> list = new ArrayList<>();
        List<String> titleslist = new ArrayList<>();
        list.clear();
        titleslist.clear();
        final List<BannerModel.DataBean> data = bannerModel.getData();
        for (BannerModel.DataBean dataBean:
             data) {
            list.add(dataBean.getImagePath());
            titleslist.add(dataBean.getTitle());
        }
        //设置banner样式
        bannerMain.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        bannerMain.setImageLoader(new GlideImageLoader());
        //设置图片集合
        bannerMain.setImages(list);
        //设置bannerMain动画效果
        bannerMain.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当bannerMain样式有显示title时）
        bannerMain.setBannerTitles(titleslist);
        //设置自动轮播，默认为true
        bannerMain.isAutoPlay(true);
        //设置轮播时间
        bannerMain.setDelayTime(1500);
        //设置指示器位置（当bannerMain模式中有指示器时）
        bannerMain.setIndicatorGravity(BannerConfig.CENTER);
        //bannerMain设置方法全部调用完毕时最后调用
        bannerMain.start();
        bannerMain.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Bundle bundle = new Bundle();
                bundle.putString("weburl", data.get(position).getUrl());
                bundle.putString("title", data.get(position).getTitle());
                RouterUtils.goToActivity(ArouteConstants.MODULE1_ARTICLE_DETAIL_ACTIVITY_PATH, bundle);
            }
        });
    }
}
