package client.com.module_3.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import client.com.module_3.R;

/**
 * 福利fragment
 * @author zxh17
 * @version 1.0
 */
public class MeiZiFragment extends Fragment {

    public MeiZiFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.module3_fragment_mei_zi, container, false);
    }


}
