package client.com.baselibs.empty_service;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import client.com.baselibs.service.IAccountService;

public class EmptyAccountService implements IAccountService {
    @Override
    public boolean isLogin() {
        return false;
    }

    @Override
    public Fragment newUserFragment(Activity activity, int containerId,
                                    FragmentManager manager, Bundle bundle, String tag) {
        return null;
    }
}
