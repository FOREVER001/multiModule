package client.com.module_2.provider;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;

import client.com.baselibs.provider.ChapterService;
import client.com.baselibs.routeconstants.ArouteConstants;
import client.com.module_2.ui.PublicArticelFragment;
@Route(path = ArouteConstants.MODULE2_PUBLICE_FRAGMENT_PATH,name = "公众号页面暴露")
public class ChapterServiceImpl implements ChapterService {
    @Override
    public Fragment getPublicArticleFragment() {
        return new PublicArticelFragment();
    }

    @Override
    public void init(Context context) {

    }
}
