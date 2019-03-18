package client.com.module_1.ui.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import client.com.module_1.R;

/**
 * 首页
 * @author zxh17
 * @version 1.0
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.module1_fragment_home, container, false);
    }


}
