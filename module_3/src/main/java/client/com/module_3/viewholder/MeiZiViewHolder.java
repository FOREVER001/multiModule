package client.com.module_3.viewholder;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseViewHolder;

import client.com.module_3.R;

public class MeiZiViewHolder extends BaseViewHolder{
    public ImageView itemIvMeizi;
    public MeiZiViewHolder(View view) {
        super(view);
        itemIvMeizi =  view.findViewById(R.id.item_iv_meizi);
    }
}
