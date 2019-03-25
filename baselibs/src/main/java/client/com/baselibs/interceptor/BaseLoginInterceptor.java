package client.com.baselibs.interceptor;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

import client.com.baselibs.constants.Constants;
import client.com.baselibs.routeconstants.ArouteConstants;
import client.com.baselibs.utils.RouterUtils;
/**
 * 声明拦截器(拦截跳转过程，面向切面编程)
 *  比较经典的应用就是在跳转过程中处理登陆事件，这样就不需要在目标页重复做登陆检查
  拦截器会在跳转之间执行，多个拦截器会按优先级顺序依次执行
 * */
@Interceptor(priority = 8, name = "登录拦截器")
public class BaseLoginInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        //需要登录才能查看的
        if(postcard.getExtra()== Constants.LOGIN_EXTRA){
            //判断是否登录。
            boolean isLogin = postcard.getExtras().getBoolean(Constants.IS_LOGIN);
            if(isLogin){
                callback.onContinue(postcard);
            }else {
                //如果没有登录，那么跳转到登录界面。
                RouterUtils.goToActivity(ArouteConstants.MODULE5_LOGIN_ACTIVITY_PATH);
            }
        }else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {

    }
}
