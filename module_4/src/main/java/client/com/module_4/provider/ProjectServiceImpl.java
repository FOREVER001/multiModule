package client.com.module_4.provider;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;

import client.com.baselibs.provider.ProjectService;
import client.com.baselibs.routeconstants.ArouteConstants;
import client.com.module_4.ui.ProjectFragment;
@Route(path = ArouteConstants.MODULE4_PROJECT_FRAGMENT_PATH)
public class ProjectServiceImpl implements ProjectService {
    @Override
    public Fragment getProjectFragment() {
        return new ProjectFragment();
    }

    @Override
    public void init(Context context) {

    }
}
