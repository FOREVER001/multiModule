package client.com.module_3.data;

import java.util.HashMap;

import client.com.baselibs.http.Http;
import io.reactivex.Observable;

public class Module3HttpData {


    public Module3HttpData() {
    }
    /**
     * 福利列表
     * @param page
     */
    public Observable getGankData(int page) {
        Observable observable = Http.getDefault().getGankData(page);
        return observable;
    }

}
