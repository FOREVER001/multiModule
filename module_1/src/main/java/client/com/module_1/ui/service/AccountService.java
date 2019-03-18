package client.com.module_1.ui.service;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import client.com.baselibs.service.IAccountService;
import client.com.module_1.ui.ui.HomeFragment;

public class AccountService implements IAccountService {
    @Override
    public boolean isLogin() {
        return false;
    }
    @Override
    public Fragment newUserFragment(Activity activity, int containerId, FragmentManager manager, Bundle bundle, String tag) {
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment homeFragment = new HomeFragment();
        transaction.add(containerId, homeFragment, tag);
        transaction.commit();
        return homeFragment;
    }
}
