package client.com.module_3.adapter;

import android.support.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import client.com.baselibs.http.model.module3.MeiziModel;
import client.com.module_3.R;
import client.com.module_3.viewholder.MeiZiViewHolder;

public class MeiziAdapter extends BaseQuickAdapter<MeiziModel.ResultsBean,MeiZiViewHolder>{
    public MeiziAdapter(@Nullable List<MeiziModel.ResultsBean> data) {
        super(R.layout.module3_item_meizi, data);
    }

    @Override
    protected void convert(MeiZiViewHolder helper, MeiziModel.ResultsBean item) {
        RequestOptions options=new RequestOptions();
         options.placeholder(R.mipmap.icon_empty_common);
              Glide.with(mContext)
                      .load(item.getUrl())
                      .apply(options)
                      .into(helper.itemIvMeizi);
    }

}
