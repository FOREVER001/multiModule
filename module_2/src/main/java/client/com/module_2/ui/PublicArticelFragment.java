package client.com.module_2.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import client.com.module_2.R;

/**
 * 公众号页面
 * @author zxh17
 * @version 1.0
 */
public class PublicArticelFragment extends Fragment{
    public PublicArticelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.module2_fragment_public_articel, container, false);
    }

}
