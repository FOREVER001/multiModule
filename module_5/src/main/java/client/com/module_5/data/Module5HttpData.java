package client.com.module_5.data;

import java.util.HashMap;

import client.com.baselibs.http.Http;
import io.reactivex.Observable;

public class Module5HttpData {
    public Module5HttpData() {
    }
    /**
     *注册
     * @param username
     * @param password
     * @param repassword
     */
    public Observable regist(String username,String password,String repassword) {
        HashMap<String,String> params=new HashMap<>(3);
        params.put("username",username);
        params.put("password",password);
        params.put("repassword",repassword);
        Observable observable = Http.getDefault().regist(params);
        return observable;
    }
    /**
     * 登录
     * @param username
     * @param password
     */
    public Observable login(String username,String password) {
        HashMap<String,String> params=new HashMap<>(2);
        params.put("username",username);
        params.put("password",password);
        Observable observable = Http.getDefault().login(params);
        return observable;
    }
}
