package client.com.baselibs.utils;

import android.widget.Toast;

/**
 *
 * Name: ToastUtils
 * Author: zxh17
 * Email:
 * Comment: Toast工具类
 * Date: 2018-07-25 10:10
 *
 */public    class ToastUtils   {
    private static Toast mToast;

    /**
     * Toast提示
     *
     * @param msg 提示内容
     */
    public static void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(RxHttpUtils.getContext(), msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }
}

