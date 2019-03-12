package client.com.baselibs.http.observer;

import android.content.Context;
import android.text.TextUtils;


import com.kaopiz.kprogresshud.KProgressHUD;

import client.com.baselibs.utils.RxHttpUtils;
import client.com.baselibs.utils.ToastUtils;
import io.reactivex.disposables.Disposable;

/**
*
* Name: CommonObserver
* Author: zxh17
* Email: 
* Comment: 通用的Observer
  用户可以根据自己需求自定义自己的类继承BaseObserver<T>即可
* Date: 2018-07-25 10:06
* 
*/public  abstract class CommonObserver<T> extends BaseObserver<T> {
    private KProgressHUD progressHUD;
    private boolean show = true;
    private Context context;
    public CommonObserver() {
    }


    public CommonObserver(Context context) {
        this.progressHUD = KProgressHUD.create(context).setCancellable(true);
        this.context = context;
    }

    public CommonObserver(Context context, boolean show) {
        this.show = show;
        this.context = context;
        this.progressHUD = KProgressHUD.create(context).setCancellable(true);
//        LogUtils.e("=====CommonObserver两个参数的构造函数===========");
    }



    private void dismissProgressDialog() {
        if (progressHUD != null && show) {
            progressHUD.dismiss();
        }

    }

    public void showProgressDialog() {
        if (progressHUD != null && show) {
            progressHUD.show();
        }
    }




    /**
     * 失败回调
     *
     * @param errorMsg
     */
    protected abstract void onError(String errorMsg);

    /**
     * 成功回调
     *
     * @param t
     */
    protected abstract void onSuccess(T t);


    @Override
    public void doOnSubscribe(Disposable d) {
//        LogUtils.e("==COMM====doOnSubscribe=====");
        if(show && progressHUD!=null){
            this.progressHUD.show();
        }
        //RxHttpUtils.addDisposable(d);
        RxHttpUtils.addToCompositeDisposable(d);
    }

    @Override
    public void doOnError(String errorMsg) {
//        LogUtils.e("==COMM====doOnError=====");
        dismissProgressDialog();
        if (!isHideToast() && !TextUtils.isEmpty(errorMsg)) {
            ToastUtils.showToast(errorMsg);
        }
        onError(errorMsg);
    }

    @Override
    public void doOnNext(T t) {
//        LogUtils.e("==COMM====doOnNext=====");
        onSuccess(t);
    }

    @Override
    public void doOnCompleted() {
//        LogUtils.e("==COMM====doOnCompleted=====");
        dismissProgressDialog();
    }
}
