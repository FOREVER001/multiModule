package client.com.baselibs.provider;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.template.IProvider;
/**
 * 公众号service
 * @author zxh17
 * @version 1.0
 * */
public interface ChapterService extends IProvider{
    Fragment getPublicArticleFragment();
}
