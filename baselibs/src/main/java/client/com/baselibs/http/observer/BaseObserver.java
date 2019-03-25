package client.com.baselibs.http.observer;


import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.IOException;

import client.com.baselibs.http.handlereult.HttpResult;
import client.com.baselibs.http.handlereult.ISubscriber;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

/**
*
* Name: BaseObserver
* Author: zxh17
* Email: 
* Comment: 基类BaseObserver
* Date: 2018-07-25 10:02
* 
*/public    abstract class BaseObserver<T> implements Observer<T>, ISubscriber<T> {
    /**
     * 是否隐藏toast
     *
     * @return
     */
    protected boolean isHideToast() {
        return false;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
//        LogUtils.e("======onSubscribe=11======");
        doOnSubscribe(d);
    }

    @Override
    public void onNext(@NonNull T t) {
//        LogUtils.e("=======onNext=11=====");

        doOnNext(t);
    }

    @Override
    public void onError(@NonNull Throwable e) {
//        LogUtils.e("=====onError==1222======");

        //这里自行替换判断网络的代码
//        String error = ApiException.handleException(e).getMessage();
        //这里自行替换判断网络的代码
       if (e instanceof HttpException){
            HttpResult errorParser = null;
            ResponseBody body = ((HttpException) e).response().errorBody();
            Gson gson = new Gson();
            TypeAdapter<HttpResult> adapter = gson.getAdapter(HttpResult.class);
            try {
                errorParser= adapter.fromJson(body.string());
            } catch (IOException a) {
                a.printStackTrace();
            }
            try {
                setError(errorParser.getErrorMsg());
            }catch (Exception e1){
                e1.printStackTrace();
            }

        }

    }


    @Override
    public void onComplete() {
//        LogUtils.e("======onComplete=======");

        doOnCompleted();
    }


    private void setError(String errorMsg) {
        doOnError(errorMsg);
    }
}
