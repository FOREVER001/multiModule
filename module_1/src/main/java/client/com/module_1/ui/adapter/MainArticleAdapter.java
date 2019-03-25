package client.com.module_1.ui.adapter;

import android.support.annotation.Nullable;
import android.text.Html;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import client.com.baselibs.http.model.module1.ArticleListModel;
import client.com.module_1.R;
/**
 * 首页文章列表adapter
 * @author zxh17
 * @version 1.0
 * */
public class MainArticleAdapter extends BaseQuickAdapter<ArticleListModel.DataBean.DatasBean,BaseViewHolder>{
    public MainArticleAdapter( @Nullable List<ArticleListModel.DataBean.DatasBean> data) {
        super(R.layout.module1_item_home_artical_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ArticleListModel.DataBean.DatasBean item) {
        helper.setText(R.id.tv_title, Html.fromHtml(item.getTitle()))
                .setText(R.id.tv_user_name, item.getAuthor())
                .setText(R.id.tv_type, item.getNiceDate())
                .setVisible(R.id.iv_new, item.isFresh())
                .addOnClickListener(R.id.iv_like);
        if (item.isCollect()) {
            helper.setImageResource(R.id.iv_like, R.mipmap.icon_like);
        } else {
            helper.setImageResource(R.id.iv_like, R.mipmap.icon_unlike);
        }
    }
}
